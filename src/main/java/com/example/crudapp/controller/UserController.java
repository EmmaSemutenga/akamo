package com.example.crudapp.controller;

import com.example.crudapp.dto.UserRegistrationDto;
import com.example.crudapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @ModelAttribute("user")
//    public UserRegistrationDto userRegistrationDto(){
//        return new UserRegistrationDto();
//    }
    @GetMapping
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDto userRegistrationDto){
        userService.save(userRegistrationDto);
        return "redirect:/registration?success";
    }
}
