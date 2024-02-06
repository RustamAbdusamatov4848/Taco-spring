package tacos.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tacos.models.User;
import org.springframework.ui.Model;
import tacos.services.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model){
        if (!service.createUser(user)){
            model.addAttribute("errorMassage",
                    "User with email " + user.getEmail() + " already exist");
            return "registration";
        }
        return "redirect:/login";
    }
}