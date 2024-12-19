package org.apache.maven.archetypes.maven_archetype_webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanController {

    private final String greetingMessage;

    @Autowired
    public BeanController(String greetingMessage) {
        this.greetingMessage = greetingMessage;
    }

    @GetMapping("/beanMessage")
    public String getGreetingMessage() {
        return greetingMessage;
    }
}
