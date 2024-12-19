package org.apache.maven.archetypes.maven_archetype_webapp.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.apache.maven.archetypes.maven_archetype_webapp.validation.ValidPercentage;

public class FormData {

    @NotBlank(message = "First Name is required")
    @Size(min = 2, message = "First Name must be at least 2 characters long")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    @Size(min = 2, message = "Last Name must be at least 2 characters long")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Degree is required")
    private String degree;

    @NotBlank(message = "Specialization is required")
    private String specialization;

    @NotBlank(message = "Phone Number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Phone Number must be 10 digits")
    private String phoneNumber;

    @ValidPercentage // Custom annotation for percentage validation
    private Integer percentage;

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Integer getPercentage() { return percentage; }
    public void setPercentage(Integer percentage) { this.percentage = percentage; }
}
