package pl.project.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.project.inventory.entity.Producer;
import pl.project.inventory.entity.Wine;
import pl.project.inventory.service.ProducerService;
import pl.project.inventory.service.WineService;

import java.util.List;


@Controller
public class WineController {


        @Autowired
        private WineService wineService;

        public WineController(WineService wineService) {
            this.wineService = wineService;
        }

        @Autowired
        private ProducerService producerService;

    @GetMapping(path="wines/list")
    public String list(Model model){

        model.addAttribute("wines", wineService.getAllWines());
        return "winesList";
    }


    @GetMapping(path = "wines/form", produces = "text/html;charset=UTF-8")
    public String showForm (Model model){
        Wine wine= new Wine();
        List<Producer> producers= producerService.getAllProducers();
        model.addAttribute("producers", producers);
        model.addAttribute("wine", wine);
        return "addWine";
    }

    @RequestMapping(path = "wines/add", method = RequestMethod.POST)
    public String addToWines(@ModelAttribute("wine") Wine wine ){
        wineService.saveWine(wine);

        return "redirect:/wines/list";
    }



    @GetMapping(path = "/wines/formEdit/{id}")
    public String UpdateForm(@PathVariable(value = "id") Integer id, Model model){
        Wine wine =wineService.getWineById(id);
        List<Producer> producers= producerService.getAllProducers();
        model.addAttribute("producers", producers);
        model.addAttribute("wine",wine);
        return "editWine";
    }

    @GetMapping(path = "/wines/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id, Model model) {

        this.wineService.deleteWineByID(id);

        return "redirect:/wines/list";
    }

    @GetMapping(path = "/wines/formEditUser/{id}")
    public String UpdateFormUser(@PathVariable(value = "id") Integer id, Model model){
        Wine wine =wineService.getWineById(id);
        model.addAttribute("wine",wine);
        return "editWineUser";
    }
    @RequestMapping(path = "/wines/addByUser" , method = RequestMethod.POST)
    public String addToWinesByUser(@ModelAttribute("wine") Wine wine ){

        wineService.saveWine(wine);

        return "redirect:/wines/list";
    }

    }
