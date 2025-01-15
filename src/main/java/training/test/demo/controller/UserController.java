package training.test.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import training.test.demo.entities.User;
import training.test.demo.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String showUserPage(){
        return  "User/user";
    }

    @GetMapping("/add")
    public String addUser(){
        return "User/addUser";
    }



    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("user")  User user, Model model, RedirectAttributes res) throws Exception{
        try{
            model.addAttribute("user",user);
            userService.save(user);
            res.addFlashAttribute("successMessage", "Utilisateur enregistré avec succès.");
            System.out.println("\n\n User registred");
            return "redirect:/auth";
        }catch (Exception e){
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace(); // Affiche la trace complète de l'exception
            res.addFlashAttribute("message", e.getMessage());
            return "redirect:/auth/register";
        }
    }
}
