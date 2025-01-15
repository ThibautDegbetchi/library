//package training.test.demo.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletResponse;
//
//@Controller
//public class CookieController {
//
//    @PostMapping("/savePreference")
//    public String savePreference(@RequestParam String key, @RequestParam String value, HttpServletResponse response) {
//        Cookie cookie = new Cookie(key, value);
//        cookie.setMaxAge(60 * 60 * 24); // Durée de vie du cookie : 1 jour
//        response.addCookie(cookie);
//        return "Preference saved in cookie!";
//    }
//
//    @GetMapping("/getPreference")
//    @ResponseBody
//    public String getPreference(@RequestParam String key, @RequestParam Cookie[] cookies) {
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals(key)) {
//                return cookie.getValue();
//            }
//        }
//        return "Preference not found!";
//    }
//}
