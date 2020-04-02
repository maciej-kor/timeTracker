package com.korit.timer.service;

import com.korit.timer.api.requests.CreateEmployeeRequest;
import com.korit.timer.api.responses.*;
import com.korit.timer.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface EmployeeService {

    ResponseEntity<CreateEmployeeResponse> createEmployee(CreateEmployeeRequest request);

    ResponseEntity<DeleteEmployeeResponse> deleteEmployee(Long id);

    ResponseEntity<UpdateEmployeeResponse> updateEmployee(Long id, CreateEmployeeRequest request);

    ResponseEntity<Set<Employee>> getAllEmployees();

    ResponseEntity<Employee> getEmployee(Long id);

    ResponseEntity<Set<Employee>> getAllEmployeesLinkedWithUser(Long userId);

}
