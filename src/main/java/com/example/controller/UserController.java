package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        userService.add(new User(name, email));
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam Long id, @RequestParam String name, @RequestParam String email) {
        User user = userService.findById(id);
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            userService.update(user);
        }
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
