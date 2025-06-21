package com.organyus.service;

import com.organyus.model.Department;
import com.organyus.model.Role;
import com.organyus.repository.RoleRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role addOne(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> addAll(List<Role> roles) {
        return roleRepository.saveAll(roles);
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> getById(ObjectId rid){
        return roleRepository.findById(rid);
    }
}
