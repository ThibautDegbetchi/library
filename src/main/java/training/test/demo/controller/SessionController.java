//package training.test.demo.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class SessionController {
//
//    @PostMapping("/savePreference")
//    public String savePreference(@RequestParam String key, @RequestParam String value, HttpSession session) {
//        session.setAttribute(key, value); // Enregistrer la préférence dans la session
//        return "Preference saved in session!";
//    }
//
//    @GetMapping("/getPreference")
//    public String getPreference(@RequestParam String key, HttpSession session) {
//        return (String) session.getAttribute(key); // Récupérer la préférence depuis la session
//    }
//}


package training.test.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import training.test.demo.entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, HttpSession session) {
        // Simulez une récupération d'utilisateur depuis une base de données (exemple simplifié)
        User user = new User(); // Remplacez par un service pour récupérer un utilisateur réel
        user.setName(username);
        session.setAttribute("loggedInUser", user); // Enregistrer l'utilisateur dans la session
        return "redirect:/home"; // Redirigez vers la page d'accueil après connexion
    }

    @GetMapping("/getLoggedUser")
    public String getLoggedUser(HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser"); // Récupérer l'utilisateur connecté
        if (loggedInUser != null) {
            return loggedInUser.getName();
        } else {
            return null;
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalider la session pour déconnecter l'utilisateur
        return "redirect:/login"; // Redirigez vers la page de connexion
    }
}

