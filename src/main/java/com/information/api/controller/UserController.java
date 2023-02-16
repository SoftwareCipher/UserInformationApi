package com.information.api.controller;

import com.information.api.entity.Status;
import com.information.api.entity.User;
import com.information.api.server.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    Service service;

    @Autowired
    public UserController(Service service) {
        this.service = service;
    }

    @PostMapping("/save")
    @ResponseBody
    public Long saveUser(@RequestBody User user){
        user.setDate(LocalDateTime.now());
        service.saveUser(user);
        return user.getId();
    }

    @GetMapping("/{id}")
    public User getUserId(@PathVariable Long id) {
        return service.getUserId(id);
    }

    @GetMapping("/allUsers")
    public List<User> allUsers(){
        return service.allUsers();
    }


    public List<User> setStatusUser(@PathVariable Long id){
        return null;
    }

    @GetMapping("/status/{status}")
    public List<User> getUsersStatus(@PathVariable boolean status) {
        return service.setStatusUser(status);
    }
}
