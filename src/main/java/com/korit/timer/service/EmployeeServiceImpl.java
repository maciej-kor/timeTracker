package com.korit.timer.service;

import com.korit.timer.api.requests.CreateEmployeeRequest;
import com.korit.timer.api.responses.CreateEmployeeResponse;
import com.korit.timer.api.responses.DeleteEmployeeResponse;
import com.korit.timer.api.responses.UpdateEmployeeResponse;
import com.korit.timer.api.responses.message.MsgSource;
import com.korit.timer.exception.CommonBadRequestException;
import com.korit.timer.exception.CommonConflictException;
import com.korit.timer.model.Employee;
import com.korit.timer.model.User;
import com.korit.timer.repository.EmployeeRepository;
import com.korit.timer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.korit.timer.exception.ValidationUtils.isNullOrEmpty;
import static com.korit.timer.exception.ValidationUtils.isNull;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl extends AbstractCommonService implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private UserRepository userRepository;

    @Autowired
    public EmployeeServiceImpl(MsgSource msgSource, EmployeeRepository employeeRepository, UserRepository userRepository) {
        super(msgSource);
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public ResponseEntity<CreateEmployeeResponse> createEmployee(CreateEmployeeRequest request) {

        validateCreateEmployeeRequest(request);
        Employee addEmployee = addEmployeeToDataSource(request);

        return ResponseEntity.ok(new CreateEmployeeResponse(msgSource.EMPLOYEEOK001, addEmployee.getId()));
    }

    private void validateCreateEmployeeRequest(CreateEmployeeRequest request) {
        if (isNullOrEmpty(request.getName()) || isNull(request.getUserId())) {
            throw new CommonBadRequestException(msgSource.EMPLOYEEERROR001);
        }
    }

    private Employee addEmployeeToDataSource(CreateEmployeeRequest request) {

        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setSurname(request.getSurname());
        employee.setPhoneNumber(request.getPhoneNumber());

        Optional<User> userOptional = userRepository.findById(request.getUserId());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.addEmployee(employee);
        } else {
            // Todo exception
            throw new CommonBadRequestException(msgSource.EMPLOYEEERROR001);
        }

        return employeeRepository.save(employee);

    }

    @Override
    @Transactional
    public ResponseEntity<DeleteEmployeeResponse> deleteEmployee(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (!employeeOptional.isPresent()) {
            throw new CommonConflictException(msgSource.USERERROR003);
        }

        employeeRepository.deleteById(id);

        return ResponseEntity.ok(new DeleteEmployeeResponse(msgSource.EMPLOYEEOK002));
    }

    @Override
    @Transactional
    public ResponseEntity<UpdateEmployeeResponse> updateEmployee(Long id, CreateEmployeeRequest request) {

        Optional<Employee> optionaEmployee = employeeRepository.findById(id);

        if (!optionaEmployee.isPresent()) {
            throw new CommonConflictException(msgSource.USERERROR003);
        }

        Employee employee = optionaEmployee.get();
        UpdateEmployeeResponse employeeResponse = new UpdateEmployeeResponse(msgSource.EMPLOYEEOK003);

        if (request.getName() != null) {
            employee.setName(request.getName());
            employeeResponse.setUpdateName(true);
        }

        if (request.getSurname() != null) {
            employee.setSurname(request.getSurname());
            employeeResponse.setUpdateSurname(true);
        }

        if (request.getPhoneNumber() != null) {
            employee.setPhoneNumber(request.getPhoneNumber());
            employeeResponse.setUpdatePhoneNumber(true);
        }

        return null;
    }

    @Override
    public ResponseEntity<Set<Employee>> getAllEmployees() {

        List<Employee> employeeList = employeeRepository.findAll();

        if (employeeList.size() == 0) {
            throw new CommonConflictException(msgSource.USERERROR005);
        }
        return ResponseEntity.ok(new HashSet<>(employeeList));
    }

    @Override
    public ResponseEntity<Employee> getEmployee(Long id) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (!optionalEmployee.isPresent()) {
            throw new CommonConflictException(msgSource.USERERROR003);
        }

        return ResponseEntity.ok(optionalEmployee.get());
    }

    @Override
    public ResponseEntity<Set<Employee>> getAllEmployeesLinkedWithUser(Long userId) {

        Optional<User> userOptional = userRepository.findById(userId);

        if (!userOptional.isPresent()) {
            throw new CommonConflictException(msgSource.USERERROR003);
        }

        return ResponseEntity.ok(userOptional.get().getEmployeeSet());
    }
}
