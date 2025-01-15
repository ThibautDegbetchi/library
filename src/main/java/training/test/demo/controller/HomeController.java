package training.test.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import training.test.demo.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomeController {
    private UserService userService;
    private SessionController sessionController;

    public HomeController(UserService userService, SessionController sessionController) {
        this.userService = userService;
        this.sessionController = sessionController;
    }


    @GetMapping("")
    public String showRedirection( HttpSession session){
        String redirection;
        if (isAuth(session))
            redirection="index";
        else
            redirection="redirect:/auth";

        return redirection;
    }

    public Boolean isAuth(HttpSession session) {
        // Récupère l'utilisateur connecté depuis la session
        return sessionController.getLoggedUser(session) != null;
    }

}
