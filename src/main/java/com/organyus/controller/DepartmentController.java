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
    public ResponseEntity<?> addOne(@Valid @RequestBody Department dept) {
        return new ResponseEntity<>(departmentService.addOne(dept), HttpStatus.OK) ;
    }

    @PostMapping("/all")
    public ResponseEntity<?> addAll(@Valid @RequestBody List<Department> depts) {
        return new ResponseEntity<>(departmentService.addAll(depts), HttpStatus.OK) ;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Department> depts = departmentService.getAll();
        if(depts.isEmpty()){
            return new ResponseEntity<>("No departments found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(depts, HttpStatus.OK);
    }

    @GetMapping("/{deptId}")
    public ResponseEntity<?> getById(@Valid @PathVariable ObjectId deptId) {
        Optional<Department> dept = departmentService.getById(deptId);
        if(dept.isEmpty()){
            return new ResponseEntity<>("No department found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dept.get(), HttpStatus.OK);
    }
}
