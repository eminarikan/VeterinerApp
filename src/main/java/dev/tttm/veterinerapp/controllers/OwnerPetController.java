package dev.tttm.veterinerapp.controllers;

import dev.tttm.veterinerapp.models.Owner;
import dev.tttm.veterinerapp.models.Pet;
import dev.tttm.veterinerapp.services.OwnerService;
import dev.tttm.veterinerapp.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/owners/{ownerId}/pets")
public class OwnerPetController {

    @Autowired
    private PetService petService;

    @Autowired
    private OwnerService ownerService;


    @GetMapping("/create")
    public String create(@PathVariable Long ownerId, Model model){
        Owner owner = ownerService.getById(ownerId);
        model.addAttribute("owner", owner);
        model.addAttribute("pet", new Pet());
        return "pets/create";
    }

    @GetMapping("/edit/{petId}")
    public String edit(@PathVariable Long ownerId, @PathVariable Long petId, Model model){
        Owner owner = ownerService.getById(ownerId);
        Pet pet = petService.getById(petId);
        model.addAttribute("owner", owner);
        model.addAttribute("pet", pet);
        return "pets/edit";
    }

    @GetMapping("/show/{petId}")
    public String show(@PathVariable Long ownerId, @PathVariable Long petId, Model model){
        Owner owner = ownerService.getById(ownerId);
        Pet pet = petService.getById(petId);
        model.addAttribute("owner", owner);
        model.addAttribute("pet", pet);
        return "pets/show";
    }

    @PostMapping("/create")
    public String store(@PathVariable Long ownerId, Model model, @Valid Pet pet, BindingResult bindingResult){
        Owner owner = ownerService.getById(ownerId);
        model.addAttribute("owner", owner);

        if (bindingResult.hasErrors()){
            model.addAttribute("createPetForm", pet);
            return "pets/create";
        }

        petService.store(owner, pet);

        model.addAttribute("message", "Hayvan " + owner.getFirstName() +" için kaydeildi");
        return "redirect:/owners/show/"+owner.getId();
    }

    @PostMapping("/edit/{petId}")
    public String update(@PathVariable Long ownerId, Model model, @PathVariable Long petId, @Valid Pet pet, BindingResult bindingResult){
        Owner owner = ownerService.getById(ownerId);
        model.addAttribute("owner", owner);

        if (bindingResult.hasErrors()){
            model.addAttribute("editPetForm", pet);
            return "pets/edit";
        }
        pet.setId(petId);
        petService.store(owner, pet);

        model.addAttribute("message", "Hayvan kaydı güncellendi!");
        return "redirect:/owners/show/"+ownerId;
    }

    @PostMapping("/delete/{petId}")
    public String delete(@PathVariable Long ownerId, @PathVariable Long petId, Model model){
        petService.delete(petId);
        model.addAttribute("message", "Kayıt silindi!");
        return "redirect:/owners/show/" + ownerId;
    }


}
