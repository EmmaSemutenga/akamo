package com.example.crudapp.services;

import com.example.crudapp.dto.UserDto;
import com.example.crudapp.model.User;

public interface UserService {
    User save(UserDto userDto);
//
//    List<UserDto> getAllUsers();
//
//    UserDto getUserById(Long id);
}
