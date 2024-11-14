package com.accounts.erp.repositories;


import com.accounts.erp.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Custom queries (if needed) can be defined here
}
