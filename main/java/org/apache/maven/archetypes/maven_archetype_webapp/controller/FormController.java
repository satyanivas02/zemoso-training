package org.apache.maven.archetypes.maven_archetype_webapp.controller;

import jakarta.validation.Valid;
import org.apache.maven.archetypes.maven_archetype_webapp.model.FormData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;

@Controller
public class FormController {
    // To display the form
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("formData", new FormData());
        return "form";
    }

    // To handle form submission
    @PostMapping("/submitForm")
    public String submitForm(
            @Valid @ModelAttribute("formData") FormData formData,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "form"; // Re-display the form with error messages
        }

        // On success
        model.addAttribute("firstName", formData.getFirstName());
        model.addAttribute("lastName", formData.getLastName());
        model.addAttribute("email", formData.getEmail());
        model.addAttribute("degree", formData.getDegree());
        model.addAttribute("specialization", formData.getSpecialization());
        model.addAttribute("phoneNumber", formData.getPhoneNumber());
        model.addAttribute("percentage", formData.getPercentage());

        return "success";
    }

}
