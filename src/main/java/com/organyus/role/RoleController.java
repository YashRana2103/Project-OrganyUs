package com.organyus.role;

import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<?> createRole(@Valid @RequestBody Role role){
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllRoles(){
        List<Role> allRoles = roleService.getAllRoles();
        if(allRoles.isEmpty()){
            return new ResponseEntity<>("No roles found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allRoles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@Valid @PathVariable ObjectId id){
        Optional<Role> roleById = roleService.getRoleById(id);
        if(roleById.isEmpty()){
            return new ResponseEntity<>("No role found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roleById.get(), HttpStatus.OK);
    }
}
