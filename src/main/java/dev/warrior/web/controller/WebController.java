package dev.warrior.web.controller;

import dev.warrior.web.dto.UserDto;
import dev.warrior.web.error.UserNotFoundException;
import dev.warrior.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getUser() {
        return "index";
    }

    @GetMapping("/@{username}")
    public String getUserByUsername(@PathVariable String username) {
        try {
            UserDto user = userService.getByUsername(username);
            System.out.println(user);
            return "username";
        } catch (UserNotFoundException e) {
            return "error";
        }
    }

}
