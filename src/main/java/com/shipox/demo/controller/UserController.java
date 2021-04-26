package com.shipox.demo.controller;

import com.shipox.demo.model.Tweet;
import com.shipox.demo.model.User;
import com.shipox.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/all")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/{name}")
    public User findByName(@PathVariable final String name) {
        return userRepository.findByName(name);
    }

    @PostMapping(value="/load")
    public User load(@RequestBody final User users) {
        userRepository.save(users);
        return userRepository.findByName(users.getName());
    }


}
