package com.information.api.controller;

import com.information.api.entity.Status;
import com.information.api.entity.User;
import com.information.api.server.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    Service service;

    @Autowired
    public UserController(Service service) {
        this.service = service;
    }

    @PostMapping("save")
    public User saveUser(@RequestBody User user){
        return service.saveUser(user);
    }

    public User getUserId(@PathVariable Long id){
        return service.getUserId(id);
    }

    public Status setStatusUser(@PathVariable Long id, @PathVariable String status){
        return service.setStatusUser(id, status);
    }
}
