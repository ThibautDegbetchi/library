package training.test.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import training.test.demo.services.StatistiqueService;

@Controller
@RequestMapping("statistiques")
public class StatisticController {
    private StatistiqueService statistiqueService;

    @GetMapping("")
    public  String showStatPage(){
        return "Stats/statistic";
    }
}
