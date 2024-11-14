package com.accounts.erp.graphql.resolvers;


import com.accounts.erp.models.Role;
import com.accounts.erp.services.RoleService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RoleResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final RoleService roleService;

    @Autowired
    public RoleResolver(RoleService roleService) {
        this.roleService = roleService;
    }

    // Query to get all roles
    @QueryMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    // Query to get a role by ID
    @QueryMapping
    public Optional<Role> getRoleById(Long id) {
        return roleService.getRoleById(id);
    }

    // Mutation to create a new role
    @QueryMapping
    public Role createRole(String name, String status, String description) {
        return roleService.createRole(name, status, description);
    }

    // Mutation to update an existing role
    @QueryMapping
    public Role updateRole(Long id, String name, String status, String description) {
        return roleService.updateRole(id, name, status, description);
    }

    // Mutation to delete a role by ID
    public String deleteRole(Long id) {
        roleService.deleteRole(id);
        return "Role deleted successfully";
    }
}
