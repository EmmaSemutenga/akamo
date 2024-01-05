package com.example.crudapp.controller;

import com.example.crudapp.dto.UserDto;
import com.example.crudapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") UserDto userDto){
        return "register";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") UserDto userDto, Model model){
        userService.save(userDto);
        model.addAttribute("message", "Registered Successfully");
//        Long id;
//        System.out.println(userService.getUserById(1L).getEmail());
//        return "redirect:/login";
        return "register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/admin-page")
    public String admin(Model model, Principal principal){
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        String roleName = !userDetails.getAuthorities().isEmpty() ? userDetails.getAuthorities().iterator().next().getAuthority() : "No roles found";
        model.addAttribute("user", userDetails);
        model.addAttribute("roleName", roleName);
        return "admin-page";
    }

    @GetMapping("/parent-page")
    public String parent(Model model, Principal principal){
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "parent-page";
    }

    @GetMapping("/resparent-page")
    public String resparent(Model model, Principal principal){
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "resparent-page";
    }

    @GetMapping("/student-page")
    public String student(Model model, Principal principal){
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "student-page";
    }

    @GetMapping("/error")
    public String notAuthorisedToAccessResource(Model model, Principal principal){
        return "error-page";
    }
}
