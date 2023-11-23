package com.example.crudapp.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Entity
@Table(name="SecurityGuard")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class SecurityGuard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // First name of the security guard
    private String firstName;

    // Last name of the security guard
    private String lastName;

    // Phone number of the security guard
    private String phoneNumber;

    // Email address of the security guard
    public String email;


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
