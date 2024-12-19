package org.apache.maven.archetypes.maven_archetype_webapp.controller;

import org.apache.maven.archetypes.maven_archetype_webapp.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public UserDTO getUserDetails() {
        // Mock data for the example
        return new UserDTO("Satya", "satya@example.com", "Admin");
    }
}
