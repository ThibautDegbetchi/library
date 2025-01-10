package training.test.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import training.test.demo.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @GetMapping("")
    public String showUserPage(){
        return  "User/user";
    }

    @GetMapping("/add")
    public String addUser(){
        return "User/addUser";
    }
}
