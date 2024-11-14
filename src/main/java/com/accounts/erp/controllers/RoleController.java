package com.accounts.erp.controllers;


import com.accounts.erp.models.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class RoleController {

    private ResponseEntity<List<Role>> getAllRoles(){
     return  null;
    }

}
