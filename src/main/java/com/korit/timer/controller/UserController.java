package com.korit.timer.controller;

import com.korit.timer.api.requests.CreateUserRequest;
import com.korit.timer.api.responses.CreateUserResponse;
import com.korit.timer.api.responses.DeleteUserResponse;
import com.korit.timer.api.responses.UpdateUserResponse;
import com.korit.timer.model.User;
import com.korit.timer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user", produces = "application/json")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request){
        return userService.createUser(request);
    }

    @DeleteMapping(value = "/user/{id}", produces = "application/json")
    public ResponseEntity<DeleteUserResponse> deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }

    @GetMapping(value = "/user/getAll", produces = "application/json")
    public ResponseEntity<Set<User>> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/user/get/{id}", produces = "application/json")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    @PutMapping(value = "/user/update/{id}", produces = "application/json")
    public ResponseEntity<UpdateUserResponse> updateUser(@PathVariable("id") Long id, @RequestBody CreateUserRequest request){
        return userService.updateUser(id, request);
    }


}
