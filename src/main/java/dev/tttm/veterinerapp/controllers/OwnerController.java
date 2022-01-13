package dev.tttm.veterinerapp.controllers;

import dev.tttm.veterinerapp.models.Owner;
import dev.tttm.veterinerapp.models.Pet;
import dev.tttm.veterinerapp.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/")
    public String index(Model model){
        List<Owner> owners = ownerService.getAll();
        model.addAttribute("owners", owners);
        return "owners/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("owner", new Owner());
        return "owners/create";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Owner owner = ownerService.getById(id);
        model.addAttribute("owner", owner);
        return "owners/edit";
    }
    @GetMapping("/show/{id}")
    public String show(@PathVariable Long id, Model model){
        Owner owner = ownerService.getById(id);
        List<Pet> pets = owner.getPets();
        model.addAttribute("owner", owner);
        model.addAttribute("pets", pets);
        return "owners/show";
    }

    @PostMapping("/create")
    public String store(@Valid Owner owner, final BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("createOwnerForm", owner);
            return "owners/create";
        }

        ownerService.store(owner);

        model.addAttribute("message", "Yeni hayvan sahibi başarıyla eklendi!");
        return "redirect:/owners/";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, @Valid Owner owner, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("editOwnerForm", owner);
            return "owners/edit";
        }
        ownerService.store(owner);
        model.addAttribute("message", "Kayıt güncellendi!");
        return "redirect:/owners/";
    }
}
