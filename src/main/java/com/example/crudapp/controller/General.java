package com.example.crudapp.controller;

import com.example.crudapp.model.DayPass;
import com.example.crudapp.model.Student;
import com.example.crudapp.repo.DayPassRepo;
import com.example.crudapp.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


/**
 * Controller class handling HTTP requests related to DayPass entities.
 * Utilizes Thymeleaf templates for rendering views.
 */
@Controller
public class General {

    @Autowired
    private DayPassRepo dayPassRepo;
    @Autowired
    private StudentRepo studentRepo;

//    private Long id = new Long(102);

    /**
     * Handles GET request to display a list of all DayPass entities.
     *
     * @param model the model to be populated and passed to the view
     * @return the view name for listing DayPass entities
     */
    @GetMapping("/welcome")
    public String listDayPasses(Model model) {
//        List<DayPass> dayPassList = dayPassRepo.findAll();
//        model.addAttribute("daypasses", dayPassList);
        return "welcome";
    }


}
