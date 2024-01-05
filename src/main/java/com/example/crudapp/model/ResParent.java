package com.example.crudapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="Residential_Parent")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResParent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // First name of the residential parent
    private String firstName;

    // Last name of the residential parent
    private String lastName;

    // Phone number of the residential parent
    private String phoneNumber;

    // Email address of the residential parent
    public String email;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "resparent"

    )
    private List<Student> students;

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
