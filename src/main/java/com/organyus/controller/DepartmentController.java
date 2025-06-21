package com.organyus.controller;

import com.organyus.model.Department;
import com.organyus.model.Role;
import com.organyus.service.DepartmentService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<?> createDepartment(@Valid @RequestBody Department department) {
        return new ResponseEntity<>(departmentService.createDepartment(department), HttpStatus.OK) ;
    }

    @GetMapping
    public ResponseEntity<?> getAllDepartments(){
        List<Department> allDepartments = departmentService.getAllDepartments();
        if(allDepartments.isEmpty()){
            return new ResponseEntity<>("No departments found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allDepartments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@Valid @PathVariable ObjectId id) {
        Optional<Department> departmentById = departmentService.getDepartmentById(id);
        if(departmentById.isEmpty()){
            return new ResponseEntity<>("No department found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(departmentById.get(), HttpStatus.OK);
    }
}
