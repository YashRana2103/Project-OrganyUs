package com.organyus.service;

import com.organyus.model.Department;
import com.organyus.model.Role;
import com.organyus.repository.DepartmentRepository;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department department) {
        departmentRepository.save(department);
        return department;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(@Valid ObjectId id) {
        return departmentRepository.findById(id);
    }
}
