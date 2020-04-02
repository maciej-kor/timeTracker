package com.korit.timer.controller;

import com.korit.timer.api.requests.CreateEmployeeRequest;
import com.korit.timer.api.requests.CreateUserRequest;
import com.korit.timer.api.responses.*;
import com.korit.timer.model.Employee;
import com.korit.timer.model.User;
import com.korit.timer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/employee/add", produces = "application/json")
    public ResponseEntity<CreateEmployeeResponse> createEmployee(@RequestBody CreateEmployeeRequest request) {
        return employeeService.createEmployee(request);
    }

    @DeleteMapping(value = "/employee/{id}", produces = "application/json")
    public ResponseEntity<DeleteEmployeeResponse> deleteUser(@PathVariable("id") Long id) {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping(value = "/employee/getAll", produces = "application/json")
    public ResponseEntity<Set<Employee>> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/employee/{id}", produces = "application/json")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id){
        return employeeService.getEmployee(id);
    }

    @PutMapping(value = "/employee/update/{id}", produces = "application/json")
    public ResponseEntity<UpdateEmployeeResponse> updateUser(@PathVariable("id") Long id, @RequestBody CreateEmployeeRequest request){
        return employeeService.updateEmployee(id, request);
    }

    @GetMapping(value = "/employee/getAll/{userId}", produces = "application/json")
    public ResponseEntity<Set<Employee>> getAllEmployeesLinkedWithUser(@PathVariable("userId") Long userId){
        return employeeService.getAllEmployeesLinkedWithUser(userId);
    }

}
