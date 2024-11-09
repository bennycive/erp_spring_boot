package com.accounts.erp.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    // Many-to-Many relationship with User (Department can have zero or more users)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "department_user",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;

    // Many-to-Many relationship with Permission (Department can have zero or more permissions)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "department_permission",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions;
}
