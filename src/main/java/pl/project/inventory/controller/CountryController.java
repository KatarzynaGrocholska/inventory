package pl.project.inventory.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.project.inventory.entity.Country;
import pl.project.inventory.service.CountryService;



@Controller
public class CountryController {


    @Autowired
    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(path="countries/list")
    public String list(Model model){

        model.addAttribute("countries", countryService.getAllCountries());
        return "countriesList";
    }


    @GetMapping(path = "countries/form", produces = "text/html;charset=UTF-8")
    public String showForm (Model model){
    Country country= new Country();
    model.addAttribute("country", country);
        return "addCountry";
    }

    @RequestMapping(path = "countries/add", method = RequestMethod.POST)
    public String addToCountries(@ModelAttribute("country") Country country ){
        countryService.saveCountry(country);

        return "redirect:/countries/list";
    }
    @GetMapping(path = "/countries/formEdit/{id}")
    public String UpdateForm(@PathVariable(value = "id") Integer id, Model model){
        Country country =countryService.getCountryById(id);
        model.addAttribute("country",country);
        return "editCountry";
    }

    @GetMapping(path = "/countries/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id, Model model) {

this.countryService.deleteCountryByID(id);

        return "redirect:/countries/list";
    }



}
