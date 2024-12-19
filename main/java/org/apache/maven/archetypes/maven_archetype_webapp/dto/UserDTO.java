package org.apache.maven.archetypes.maven_archetype_webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private String username;
    private String email;
    private String role;

}



//package org.apache.maven.archetypes.maven_archetype_webapp.dto;
//
//public class UserDTO {
//    private String username;
//    private String email;
//    private String role;
//
//    // Constructor
//    public UserDTO(String username, String email, String role) {
//        this.username = username;
//        this.email = email;
//        this.role = role;
//    }
//
//    // Getters and Setters
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//}
