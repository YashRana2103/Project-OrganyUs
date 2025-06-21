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

    public Department addOne(Department dept) {
        return departmentRepository.save(dept);
    }

    public List<Department> addAll(List<Department> depts) {
        return departmentRepository.saveAll(depts);
    }

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getById(@Valid ObjectId deptId) {
        return departmentRepository.findById(deptId);
    }
}
