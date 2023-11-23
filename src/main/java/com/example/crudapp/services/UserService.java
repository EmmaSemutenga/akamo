package com.example.crudapp.services;

import com.example.crudapp.dto.UserRegistrationDto;
import com.example.crudapp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto userRegistrationDto);
}
