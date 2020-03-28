package com.korit.timer.service;

import com.korit.timer.api.requests.CreateUserRequest;
import com.korit.timer.api.responses.CreateUserResponse;
import com.korit.timer.api.responses.DeleteUserResponse;
import com.korit.timer.api.responses.UpdateUserResponse;
import com.korit.timer.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface UserService {

    ResponseEntity<CreateUserResponse> createUser(CreateUserRequest request);

    ResponseEntity<DeleteUserResponse> deleteUser(Long id);

    ResponseEntity<UpdateUserResponse> updateUser(Long id, CreateUserRequest request);

    ResponseEntity<Set<User>> getAllUsers();

    ResponseEntity<User> getUser(Long id);



}
