package pl.project.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.project.inventory.entity.Employee;

@Controller
public class HomeController {

    @GetMapping(path="/home")
    public String home(){
        return "homePage";
    }
}
