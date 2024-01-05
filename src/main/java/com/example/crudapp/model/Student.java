package com.example.crudapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Student")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // First name of the student
    private String firstName;

    // Last name of the student
    private String lastName;

    // Grade of the student
    private String grade;

    // Phone number of the student
    private String phoneNumber;

    // Email address of the student
    public String email;

    // List of day passes associated with the student
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "student"
    )

    private List<DayPass> daypasses =  new ArrayList<>();

    // Parent associated with the student
    @ManyToOne
    @JoinColumn(
            name = "parent_id"
    )
    private Parent parent;

    // Residential parent associated with the student
    @ManyToOne
    @JoinColumn(
            name = "res_parent_id"
    )
    private ResParent resparent;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    // Getter and Setter methods for 'firstName'
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter methods for 'lastName'
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and Setter methods for 'grade'
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Getter and Setter methods for 'phoneNumber'
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter methods for 'email'
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
