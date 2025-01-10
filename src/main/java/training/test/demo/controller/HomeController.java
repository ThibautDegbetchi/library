package training.test.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("")
    public String showRedirection(){
        String redirection;
        if (isAuth())
            redirection="index";
        else
            redirection="Authentification/login";

        return redirection;
    }

    public String showRegisterScreen(){
        return "Authentification/register";
    }

    public Boolean isAuth(){
        return false;
    }

}
