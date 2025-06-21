package com.organyus.controller;

import com.organyus.model.User;
import com.organyus.service.UserService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> addOne(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.addOne(user), HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<?> addAll(@Valid @RequestBody List<User> users) {
        return new ResponseEntity<>(userService.addAll(users), HttpStatus.OK) ;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<User> users = userService.getAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>("No users found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{uid}")
    public ResponseEntity<?> getById(@Valid @PathVariable ObjectId uid) {
        Optional<User> user = userService.getById(uid);
        if (user.isEmpty()) {
            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }
}
