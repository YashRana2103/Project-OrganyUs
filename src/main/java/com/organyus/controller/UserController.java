package com.organyus.controller;

import com.organyus.model.User;
import com.organyus.service.UserService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        if (allUsers.isEmpty()) {
            return new ResponseEntity<>("No users found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@Valid @PathVariable ObjectId id) {
        Optional<User> optionalUser = userService.getUserById(id);
        if (optionalUser.isEmpty()) {
            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
    }
}
