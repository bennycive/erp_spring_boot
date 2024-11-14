package com.accounts.erp.services;

import com.accounts.erp.models.Role;
import com.accounts.erp.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public Role createRole(String name, String status, String description) {
        Role role = new Role();
        role.setName(name);
        role.setStatus(status);
        role.setDescription(description);
        return roleRepository.save(role);
    }

    public Role updateRole(Long id, String name, String status, String description) {
        return roleRepository.findById(id).map(role -> {
            role.setName(name);
            role.setStatus(status);
            role.setDescription(description);
            return roleRepository.save(role);
        }).orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
