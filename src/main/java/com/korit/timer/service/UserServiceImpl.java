package com.korit.timer.service;

import com.korit.timer.api.responses.message.MsgSource;
import com.korit.timer.api.responses.UpdateUserResponse;
import com.korit.timer.exception.CommonBadRequestException;
import com.korit.timer.exception.CommonConflictException;
import com.korit.timer.model.User;
import com.korit.timer.repository.UserRepository;
import com.korit.timer.api.requests.CreateUserRequest;
import com.korit.timer.api.responses.CreateUserResponse;
import com.korit.timer.api.responses.DeleteUserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.korit.timer.exception.ValidationUtils.isNullOrEmpty;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends AbstractCommonService implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(MsgSource msgSource, UserRepository userRepository) {
        super(msgSource);
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public ResponseEntity<CreateUserResponse> createUser(CreateUserRequest request) {

        validateCreateUserRequest(request);
        checkIfUserNicknameExist(request);
        User addedUser = addUserToDataSource(request);

        return ResponseEntity.ok(new CreateUserResponse(msgSource.USEROK001, addedUser.getId()));
    }

    private void validateCreateUserRequest(CreateUserRequest request) {

        if (isNullOrEmpty(request.getNickname()) || isNullOrEmpty(request.getPassword())) {
            throw new CommonBadRequestException(msgSource.USERERROR001);
        }

    }

    private void checkIfUserNicknameExist(CreateUserRequest request) {

        if (userRepository.findUserByNickname(request.getNickname()).isPresent()) {
            throw new CommonConflictException(msgSource.USERERROR004);
        }

    }

    private User addUserToDataSource(CreateUserRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setNickname(request.getNickname());
        user.setMailAddress(request.getMailAddress());
        user.setSurname(request.getSurname());
        user.setPassword(request.getPassword());

        return userRepository.save(user);

    }

    @Override
    @Transactional
    public ResponseEntity<DeleteUserResponse> deleteUser(Long id) {

        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent()) {
            throw new CommonConflictException(msgSource.USERERROR003);
        }

        userRepository.deleteById(id);

        return ResponseEntity.ok(new DeleteUserResponse(msgSource.USEROK002));

    }

    @Override
    public ResponseEntity<Set<User>> getAllUsers() {

        List<User> users = userRepository.findAll();

        if (users.size() == 0) {
            throw new CommonConflictException(msgSource.USERERROR005);
        }

        return ResponseEntity.ok(new HashSet<>(users));

    }

    @Override
    public ResponseEntity<User> getUser(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            throw new CommonConflictException(msgSource.USERERROR003);
        }

        return ResponseEntity.ok(optionalUser.get());

    }

    @Override
    @Transactional
    public ResponseEntity<UpdateUserResponse> updateUser(Long id, CreateUserRequest request) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            throw new CommonConflictException(msgSource.USERERROR003);
        }

        User user = optionalUser.get();
        UpdateUserResponse userResponse = new UpdateUserResponse(msgSource.USEROK003);

        if (request.getNickname() != null) {
            checkIfUserNicknameExist(request);
            user.setNickname(request.getNickname());
            userResponse.setUpdateNickname(true);
        }

        if (request.getPassword() != null) {
            user.setPassword(request.getPassword());
            userResponse.setUpdatePassword(true);
        }

        if (request.getMailAddress() != null) {
            user.setMailAddress(request.getMailAddress());
            userResponse.setUpdateMailAddress(true);
        }

        if (request.getName() != null) {
            user.setName(request.getName());
            userResponse.setUpdateName(true);
        }

        if (request.getSurname() != null) {
            user.setSurname(request.getSurname());
            userResponse.setUpdateSurname(true);
        }

        userRepository.save(user);

        return ResponseEntity.ok(userResponse);
    }


}
