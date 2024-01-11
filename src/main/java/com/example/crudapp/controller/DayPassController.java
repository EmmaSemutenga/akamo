package com.example.crudapp.controller;

//import com.example.crudapp.forms.DayPassForm;
import com.example.crudapp.model.DayPass;
import com.example.crudapp.model.Parent;
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
public class DayPassController {
//    stacks are applied to the request processing flow in Spring MVC, specifically when handling HTTP requests in controllers

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
    @GetMapping("/daypasses")
    public String listDayPasses(Model model) {
        List<DayPass> dayPassList = dayPassRepo.findAll();
        model.addAttribute("daypasses", dayPassList);
        return "list-daypasses";
    }

    /**
     * Handles GET request to display the form for adding a new DayPass entity.
     *
     * @param model the model to be populated and passed to the view
     * @return the view name for adding a DayPass entity
     */
    @GetMapping("/add-daypass")
    public String showDayPassForm(Model model) {
        model.addAttribute("daypass", new DayPass());
        List<Student> studentList = studentRepo.findAll();
        model.addAttribute("students", studentList);
        return "add-daypass";
    }

    /**
     * Handles POST request to save a new DayPass entity.
     *
     * @param dayPass the DayPass entity to be saved
     * @return the redirect URL to the list of DayPass entities
     */
    @PostMapping("/save-daypass")
    public String saveDayPass(@ModelAttribute("daypass") DayPass dayPass) {

//        Student student = studentRepo.findById("102").orElse(null);

        System.out.println(dayPass);
        dayPassRepo.save(dayPass);
        return "redirect:/add-daypass";
    }

    /**
     * Handles GET request to display the form for editing an existing DayPass entity.
     *
     * @param id    the ID of the DayPass entity to be edited
     * @param model the model to be populated and passed to the view
     * @return the view name for editing a DayPass entity
     */
    @GetMapping("/edit-daypass/{id}")
    public String showEditDayPassForm(@PathVariable Long id, Model model) {
        DayPass dayPass = dayPassRepo.findById(id).orElse(null);
        //System.out.println(dayPass.getReason());
        model.addAttribute("daypass", dayPass);
        List<Student> studentList = studentRepo.findAll();
        model.addAttribute("students", studentList);
        return "edit-daypass";
    }

    /**
     * Handles GET request to delete an existing DayPass entity.
     *
     * @param id the ID of the DayPass entity to be deleted
     * @return the redirect URL to the list of DayPass entities
     */
    @GetMapping("/delete-daypass/{id}")
    public String deleteDayPass(@PathVariable Long id) {
        dayPassRepo.deleteById(id);
        return "redirect:/daypasses";
    }


}
