package training.test.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import training.test.demo.entities.User;
import training.test.demo.services.UserService;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SessionController sessionController;


    public AuthController(UserService userService, PasswordEncoder passwordEncoder/*, SessionController sessionController*/) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.sessionController = sessionController;
    }

    @GetMapping("register")
    public String showRegisterScreen(Model model) {
        model.addAttribute("user", new User());
        return "Authentification/register";
    }

    @GetMapping("")
    public String showLoginScreen(Model model) {
        model.addAttribute("auth", new LoginRequest("", ""));

        return "Authentification/login";
    }

    @PostMapping("login")
    public String login(@ModelAttribute("auth") LoginRequest loginRequest, Model model, RedirectAttributes res,HttpSession session) {
        model.addAttribute("auth", loginRequest);
        System.out.println("Email :" + loginRequest.getEmail());
        System.out.println("Password :" + loginRequest.getPassword());
        User user = userService.findUserByEmail(loginRequest.getEmail());
        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            sessionController.loginUser(loginRequest.getEmail(), session);
            res.addFlashAttribute("success", "Connexion réussie !");
            System.out.println("\n\nConnexion réussit!!!");
            return "redirect:/home";
        }
        String errorMessage = user == null ? "Email incorrect." : "Mot de passe incorrect.";
        res.addFlashAttribute("error", errorMessage);
        return "redirect:/auth";
    }

    @GetMapping("logout")
    public String logout(Model model,RedirectAttributes res,HttpSession session){
        sessionController.logout(session);
        return "Authentification/login";
    }

    public class LoginRequest {
        private String email;
        private String password;

        public LoginRequest(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
