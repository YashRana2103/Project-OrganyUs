package com.organyus.controller;

import com.organyus.model.User;
import com.organyus.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<User> addOne(@Valid @RequestBody User user) {
        User savedUser = userService.addOne(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<List<User>> addAll(@Valid @RequestBody List<User> users) {
        List<User> savedUsers = userService.addAll(users);
        return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/id/{uid}")
    public ResponseEntity<?> getById(@PathVariable String uid) {
            ObjectId objectId = new ObjectId(uid);
            Optional<User> user = userService.getById(objectId);
            if (user.isEmpty()) {
                return new ResponseEntity<>("User by ObjectId(\"" + uid + "\") not found!", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String username) {
        Optional<User> user = userService.getByUsername(username);
        if (user.isEmpty()) {
            return new ResponseEntity<>("User with username '" + username + "' not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    // TODO: Uncomment and implement the following methods as needed

    // GET - getByEmail
    // Path: GET /api/users/email
    @GetMapping("/email")
    public ResponseEntity<?> getByEmail(@RequestParam @Email(message = "Invalid email format") String email){
        Optional<User> user = userService.getByEmail(email);
        if (user.isEmpty()) {
            return new ResponseEntity<>("User by Email(\"" + email + "\") not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    // PUT - updateById
    // Path: PUT /api/users

    // PUT - updateByEmail
    // Path: PUT /api/users/email/{email}

    // DELETE-  deleteById
    // Path: DELETE /api/users/{id}

    // PATCH - toggleStateById
    // Path: PATCH /api/users/{id}/toggle-state

    // TODO: ADMIN-ONLY METHODS

    // GET - getAllByState // to get all users by their state (active/inactive)
    // Path: GET /api/admin/users/state/{state}

    // GET - getAllActive // to get all active users
    // Path: GET /api/admin/users/active

    // DELETE - deleteAll // to delete all users (admin only)
    // Path: DELETE /api/admin/users

    // TODO: Later

    // GET - getAllByDeptId
    // Path: GET /api/users/department/{deptId}

    // GET - getAllByRoleId
    // Path: GET /api/users/role/{roleId}

    // GET - getByName
    // Path: GET /api/users/name/{name}

    // POST - updateAllStateById // to update state of all users by their IDs
    // Path: POST /api/admin/users/state/batch

    // PATCH - updatePwdById // to update password by user ID
    // Path: PATCH /api/users/{id}/password

    // PATCH - updateProfileById // to update profile details by user ID
    // Path: PATCH /api/users/{id}/profile

}
