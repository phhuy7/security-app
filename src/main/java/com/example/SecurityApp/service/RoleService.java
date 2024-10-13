package com.example.SecurityApp.service;

import com.example.SecurityApp.model.Role;
import com.example.SecurityApp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Optional<Role> findRoleById(UUID roleId) {
        return roleRepository.findById(roleId);
    }

}