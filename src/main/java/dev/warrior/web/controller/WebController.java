package dev.warrior.web.controller;

import dev.warrior.web.dto.input.UserInputDto;
import dev.warrior.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getUser() {
        return "index";
    }

    @GetMapping("/@{username}")
    public ModelAndView getUserByUsername(@PathVariable String username) {
        //UserInputDto user = userService.getByUsername(username);
        UserInputDto user = null;
        ModelAndView mv = new ModelAndView("index");

        mv.addObject("user", user);
        System.out.println(user);
        return mv;
    }

}
