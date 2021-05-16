package pl.project.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.project.inventory.entity.User;
import pl.project.inventory.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path="users/list")
    public String list(Model model){

        model.addAttribute("users", userService.getAllUsers());
        return "usersList";
    }


    @GetMapping(path = "users/form", produces = "text/html;charset=UTF-8")
    public String showForm (Model model){
        User user= new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @RequestMapping(path = "users/add", method = RequestMethod.POST)
    public String addToCountries(@ModelAttribute("user") User user ){
        userService.saveUser(user);

        return "redirect:/users/list";
    }
    @GetMapping(path = "/users/formEdit/{id}")
    public String UpdateForm(@PathVariable(value = "id") Integer id, Model model){
        User user =userService.getUserById(id);
        model.addAttribute("user",user);
        return "editUser";
    }

    @GetMapping(path = "/users/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id, Model model) {

        this.userService.deleteUserByID(id);

        return "redirect:/users/list";
    }


}
