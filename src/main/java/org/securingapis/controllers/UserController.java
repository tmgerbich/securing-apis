package org.securingapis.controllers;


import org.securingapis.models.User;
import org.securingapis.models.Role;
import org.securingapis.models.RoleName;
import org.securingapis.services.UserService;
import org.securingapis.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByRoleName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        roles.add(userRole);

        user.setRoles(roles);
        userService.save(user);
        return "User registered successfully";
    }
}
