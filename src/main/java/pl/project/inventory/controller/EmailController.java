package pl.project.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.project.inventory.entity.Country;
import pl.project.inventory.entity.Wine;
import pl.project.inventory.service.CountryService;
import pl.project.inventory.service.EmailService;
import pl.project.inventory.service.WineService;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {

    private EmailService emailService;
private WineService wineService;
private CountryService countryService;
@Autowired
    public EmailController(EmailService emailService, WineService wineService, CountryService countryService) {
        this.emailService = emailService;
        this.wineService = wineService;
        this.countryService = countryService;
    }




    public EmailController(EmailService emailService) {
        this.emailService = emailService;

    }

    @RequestMapping(path = "/email")
    @ResponseBody
    public String sendHtmlMessage(Model model, Wine wine, Country country) throws MessagingException {
       // Wine wine = new Wine();
       // Country country = new Country();
//        List<Wine> wines = new ArrayList<>();
//
//        for (Wine w : wines) {
//            if (w.getMonthly() <= country.getDays_delivery()) {
//              //  model.getAttribute("wine", wine);
//              //  model.getAttribute("country", countryService.getAllCountries());
//              //  model.getAttribute("wines", wineService.getAllWines());
//
//                emailService.sendHtmlMessage("admin@inventory.pl",
//                        "Zamow");
//
//            }
//
//            emailService.sendHtmlMessageEmpty("admin@inventory.pl",
//                    "Zamow");
//
//        }
        emailService.sendHtmlMessage("admin@inventory.pl",
                       "Zamow");

        return "wiadomoc wyslana";

    }
}