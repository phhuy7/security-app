package com.example.SecurityApp.controller;

import com.example.SecurityApp.dto.PermissionDTO;
import com.example.SecurityApp.model.Permission;
import com.example.SecurityApp.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping
    public ResponseEntity<Permission> createPermission(@RequestBody PermissionDTO permissionDTO) {
        Permission permission = new Permission();
        permission.setPermissionName(permissionDTO.getPermissionName());

        Permission createdPermission = permissionService.createPermission(permission);
        return ResponseEntity.status(201).body(createdPermission);
    }

    @GetMapping("/{permissionId}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable UUID permissionId) {
        Optional<Permission> permission = permissionService.findPermissionById(permissionId);
        return permission.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Additional permission management methods can be added here
}