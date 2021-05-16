package pl.project.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.project.inventory.entity.Country;
import pl.project.inventory.entity.Producer;
import pl.project.inventory.service.CountryService;
import pl.project.inventory.service.ProducerService;

import java.util.List;


@Controller
public class ProducerController {

        @Autowired
        private ProducerService producerService;

        public ProducerController(ProducerService producerService) {
            this.producerService = producerService;

            }
            @Autowired
            private CountryService countryService;

            @GetMapping(path="producers/list")
            public String list(Model model){

                model.addAttribute("producers", producerService.getAllProducers());
                return "producersList";
            }


            @GetMapping(path = "producers/form", produces = "text/html;charset=UTF-8")
            public String showForm (Model model){
                Producer producer= new Producer();
                List<Country> countries= countryService.getAllCountries();
                model.addAttribute("countries", countries);
                model.addAttribute("producer", producer);
                return "addProducer";
            }

            @RequestMapping(path = "producers/add", method = RequestMethod.POST)
            public String addToProducers(@ModelAttribute("producer") Producer producer ){
                producerService.saveProducer(producer);

                return "redirect:/producers/list";
            }

            @GetMapping(path = "/producers/formEdit/{id}")
            public String UpdateForm(@PathVariable(value = "id") Integer id, Model model){
                Producer producer =producerService.getProducerById(id);
                List<Country> countries= countryService.getAllCountries();
                model.addAttribute("countries", countries);
                model.addAttribute("producer",producer);
                return "editProducer";
            }

    @GetMapping (path="/producers/deleteConsent/{id}")
    public String delConsent(@PathVariable(value = "id") Integer id, Model model) {
        Producer producer = producerService.getProducerById(id);
        model.addAttribute("producer", producer);

        return "ConsentDeleteProducer";
    }

            @GetMapping(path = "/producers/delete/{id}")
            public String delete(@PathVariable(value = "id") Integer id, Model model) {

                this.producerService.deleteProducerByID(id);

                return "redirect:/producers/list";
            }

    }
