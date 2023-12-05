package com.todocodeacademy.usersservice.controller;

import com.todocodeacademy.usersservice.dto.UserDTO;
import com.todocodeacademy.usersservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/posts/{user_id}")
    public UserDTO getUserAndPosts(@PathVariable("user_id") Long user_id){
        UserDTO user = iUserService.getUserAndPosts(user_id);

        return user;
    }
}
