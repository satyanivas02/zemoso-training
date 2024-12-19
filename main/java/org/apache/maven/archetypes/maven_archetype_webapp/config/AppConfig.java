package org.apache.maven.archetypes.maven_archetype_webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean

    public String greetingMessage() {
        return "Hello from Spring Bean!  This is a default bean which is having singleton Scope";
    }
}
