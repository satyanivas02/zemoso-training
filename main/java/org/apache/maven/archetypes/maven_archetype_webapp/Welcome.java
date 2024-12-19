package org.apache.maven.archetypes.maven_archetype_webapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to spring world";
    }
}
