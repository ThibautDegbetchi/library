//package training.test.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import training.test.demo.services.PreferenceService;
//
//@RestController
//@RequestMapping("pref")
//public class PreferenceController {
//
//    @Autowired
//    private PreferenceService preferenceService;
//
//    @PostMapping("/savePreference")
//    public String savePreference(@RequestParam String key, @RequestParam String value) {
//        preferenceService.savePreference(key, value);
//        return "Preference saved!";
//    }
//
//    @GetMapping("/getPreference")
//    public String getPreference(@RequestParam String key) {
//        return preferenceService.getPreference(key);
//    }
//}
