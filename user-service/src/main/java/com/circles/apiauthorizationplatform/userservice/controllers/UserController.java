package com.circles.apiauthorizationplatform.userservice.controllers;

import com.circles.apiauthorizationplatform.userservice.models.User;
import com.circles.apiauthorizationplatform.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") String id) {
        return userService.getById(id);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
}
