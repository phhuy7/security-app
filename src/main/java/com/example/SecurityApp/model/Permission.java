package com.example.SecurityApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Permissions")
public class Permission {

    @Id
    @GeneratedValue
    @Column(name = "permission_id", unique = true, nullable = false)
    private UUID permissionId = UUID.randomUUID();;

    @Column(name = "permission_name", unique = true, nullable = false)
    private String permissionName;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;
}