package dev.tttm.veterinerapp.controllers;

import dev.tttm.veterinerapp.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/owners")
public class AdminOwnerContoller {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        ownerService.delete(id);
        model.addAttribute("message", "Kayıt Silindi!");
        return "redirect:/owners/";
    }
}
