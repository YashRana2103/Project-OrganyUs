package com.organyus.service;

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

    public Role createRole(Role role) {
        roleRepository.save(role);
        return role;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(ObjectId id){
        return roleRepository.findById(id);
    }
}
