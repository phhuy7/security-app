package com.example.SecurityApp.controller;

import com.example.SecurityApp.dto.RoleDTO;
import com.example.SecurityApp.model.Role;
import com.example.SecurityApp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody RoleDTO roleDTO) {
        Role role = new Role();
        role.setRoleName(roleDTO.getRoleName());

        Role createdRole = roleService.createRole(role);
        return ResponseEntity.status(201).body(createdRole);
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<Role> getRoleById(@PathVariable UUID roleId) {
        Optional<Role> role = roleService.findRoleById(roleId);
        return role.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Additional role management methods can be added here
}