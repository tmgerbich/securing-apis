package org.securingapis.config;

import org.securingapis.models.Role;
import org.securingapis.models.RoleName;
import org.securingapis.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if roles exist, if not, add them to the database
        if (roleRepository.findByRoleName(RoleName.ROLE_USER).isEmpty()) {
            Role userRole = new Role(RoleName.ROLE_USER);
            roleRepository.save(userRole);
        }

        if (roleRepository.findByRoleName(RoleName.ROLE_ADMIN).isEmpty()) {
            Role adminRole = new Role(RoleName.ROLE_ADMIN);
            roleRepository.save(adminRole);
        }

        System.out.println("Roles initialized.");
    }
}
