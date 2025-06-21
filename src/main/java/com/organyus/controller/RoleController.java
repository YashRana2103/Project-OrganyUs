package com.organyus.controller;

import com.organyus.model.Department;
import com.organyus.model.Role;
import com.organyus.service.RoleService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<?> addOne(@Valid @RequestBody Role role){
        return new ResponseEntity<>(roleService.addOne(role), HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<?> addAll(@Valid @RequestBody List<Role> roles) {
        return new ResponseEntity<>(roleService.addAll(roles), HttpStatus.OK) ;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Role> roles = roleService.getAll();
        if(roles.isEmpty()){
            return new ResponseEntity<>("No roles found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{rid}")
    public ResponseEntity<?> getById(@Valid @PathVariable ObjectId rid){
        Optional<Role> role = roleService.getById(rid);
        if(role.isEmpty()){
            return new ResponseEntity<>("No role found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(role.get(), HttpStatus.OK);
    }
}
