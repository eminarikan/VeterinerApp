package dev.tttm.veterinerapp.controllers;

import dev.tttm.veterinerapp.services.OwnerService;
import dev.tttm.veterinerapp.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @Autowired
    private PetService petService;

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/")
    public String welcome(Model model){
        model.addAttribute("ownerCount", ownerService.count());
        model.addAttribute("petCount", petService.count());
        return "welcome";
    }
}
