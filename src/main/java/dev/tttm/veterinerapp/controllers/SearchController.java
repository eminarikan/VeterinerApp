package dev.tttm.veterinerapp.controllers;

import dev.tttm.veterinerapp.models.Owner;
import dev.tttm.veterinerapp.models.Pet;
import dev.tttm.veterinerapp.services.OwnerService;
import dev.tttm.veterinerapp.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private OwnerService ownerService;

    @Autowired
    private PetService petService;

    @GetMapping("/search")
    public String search(Model model, @Param("keyword") String keyword){
        List<Owner> owners = ownerService.search(keyword);
        List<Pet> pets = petService.search(keyword);
        model.addAttribute("owners", owners);
        model.addAttribute("pets", pets);
        return "searchResult";
    }
}
