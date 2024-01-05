package com.example.crudapp.controller;

import com.example.crudapp.model.Parent;
import com.example.crudapp.model.User;
import com.example.crudapp.model.ResParent;
import com.example.crudapp.model.Student;
import com.example.crudapp.repo.ParentRepo;
import com.example.crudapp.repo.ResParentRepo;
import com.example.crudapp.repo.StudentRepo;
import com.example.crudapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Controller class for handling HTTP requests related to Student entities.
 * Utilizes Spring Model to carry data between the controller and the view templates.
 */
@Controller
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ParentRepo parentRepo;

    @Autowired
    private ResParentRepo resParentRepo;

    @Autowired
    private UserRepository userRepository;

    /**
     * Handles GET request to retrieve all Student entities.
     *
     * @param model Spring Model for carrying data to the view template
     * @return String representing the name of the view template to render
     */
    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> studentList = studentRepo.findAll();
        model.addAttribute("students", studentList);
        return "list-students";
    }

    /**
     * Handles GET request to display the form for adding a new Student entity.
     *
     * @param model Spring Model for carrying data to the view template
     * @return String representing the name of the view template to render
     */
    @GetMapping("/add-student")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        List<Parent> parentList = parentRepo.findAll();
        model.addAttribute("parents", parentList);
        List<ResParent> resParentList = resParentRepo.findAll();
        model.addAttribute("resparents", resParentList);
        List<User> userList = userRepository.findAll();
        model.addAttribute("users", userList);
        return "add-student";
    }

    /**
     * Handles POST request to save a new Student entity.
     *
     * @param student Student entity to be added
     * @return String representing the redirect path after saving the student
     */
    @PostMapping("/save-student")
    public String saveBook(@ModelAttribute("student") Student student) {
        studentRepo.save(student);
        return "redirect:/students";
    }

    /**
     * Handles GET request to display the form for editing an existing Student entity.
     *
     * @param id    ID of the Student entity to be edited
     * @param model Spring Model for carrying data to the view template
     * @return String representing the name of the view template to render
     */
    @GetMapping("/edit-student/{id}")
    public String showEditStudentForm(@PathVariable Long id, Model model) {
        Student student = studentRepo.findById(id).orElse(null);
        model.addAttribute("student", student);

        // Fetches the list of parents and residential parents for dropdown selection
        List<Parent> parentList = parentRepo.findAll();
        model.addAttribute("parents", parentList);
        List<ResParent> resParentList = resParentRepo.findAll();
        model.addAttribute("resparents", resParentList);
        List<User> userList = userRepository.findAll();
        model.addAttribute("users", userList);

        return "edit-student";
    }

    /**
     * Handles GET request to delete an existing Student entity.
     *
     * @param id ID of the Student entity to be deleted
     * @return String representing the redirect path after deleting the student
     */
    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepo.deleteById(id);
        return "redirect:/students";
    }

}
