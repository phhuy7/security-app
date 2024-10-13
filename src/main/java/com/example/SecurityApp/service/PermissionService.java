package com.example.SecurityApp.service;

import com.example.SecurityApp.model.Permission;
import com.example.SecurityApp.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public Optional<Permission> findPermissionById(UUID permissionId) {
        return permissionRepository.findById(permissionId);
    }

}