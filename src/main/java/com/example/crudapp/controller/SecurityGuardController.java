package com.example.crudapp.controller;

import com.example.crudapp.model.Parent;
import com.example.crudapp.model.ResParent;
import com.example.crudapp.model.SecurityGuard;
import com.example.crudapp.repo.ParentRepo;
import com.example.crudapp.repo.ResParentRepo;
import com.example.crudapp.repo.SecurityGuardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Controller class handling HTTP requests related to Residential Parent (ResParent) entities.
 * Utilizes Thymeleaf templates for rendering views.
 */
@Controller
public class SecurityGuardController {
    @Autowired
    private SecurityGuardRepo securityGuardRepo;

    /**
     * Handles GET request to display a list of all Residential Parent (ResParent) entities.
     *
     * @param model the model to be populated and passed to the view
     * @return the view name for listing ResParent entities
     */
    @GetMapping("/securityguards")
    public String listSecurityGuards(Model model) {
        List<SecurityGuard> securityGuardList = securityGuardRepo.findAll();
        model.addAttribute("securityguards", securityGuardList);
        return "list-securityguards";
    }

    /**
     * Handles GET request to display the form for adding a new Residential Parent (ResParent) entity.
     *
     * @param model the model to be populated and passed to the view
     * @return the view name for adding a ResParent entity
     */
    @GetMapping("/add-securityguard")
    public String showSecurityGuardForm(Model model) {
        model.addAttribute("securityguard", new SecurityGuard());
        return "add-securityguard";
    }

    /**
     * Handles POST request to save a new Residential Parent (ResParent) entity.
     *
     * @param resParent the ResParent entity to be saved
     * @return the redirect URL to the list of ResParent entities
     */
    @PostMapping("/save-securityguard")
    public String saveSecurityGuard(@ModelAttribute("securityguard") SecurityGuard securityGuard) {
        securityGuardRepo.save(securityGuard);
        return "redirect:/securityguards";
    }

    /**
     * Handles GET request to display the form for editing an existing Residential Parent (ResParent) entity.
     *
     * @param id    the ID of the ResParent entity to be edited
     * @param model the model to be populated and passed to the view
     * @return the view name for editing a ResParent entity
     */
    @GetMapping("/edit-securityguard/{id}")
    public String showEditSecurityGuardForm(@PathVariable Long id, Model model) {
        SecurityGuard securityGuard = securityGuardRepo.findById(id).orElse(null);
        model.addAttribute("securityguard", securityGuard);
        return "edit-securityguard";
    }

    /**
     * Handles GET request to delete an existing Residential Parent (ResParent) entity.
     *
     * @param id the ID of the ResParent entity to be deleted
     * @return the redirect URL to the list of ResParent entities
     */
    @GetMapping("/delete-securityguard/{id}")
    public String deleteSecurityGuard(@PathVariable Long id) {
        securityGuardRepo.deleteById(id);
        return "redirect:/securityguards";
    }
}

