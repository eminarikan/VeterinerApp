package dev.tttm.veterinerapp.api.controller;

import dev.tttm.veterinerapp.models.Pet;
import dev.tttm.veterinerapp.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetRestController {

    @Autowired
    private PetService petService;

    @GetMapping(path = {"","/"})
    public ResponseEntity<List<Pet>> index(){
        List<Pet> pets = petService.getAll();
        return ResponseEntity.ok(pets);
    }
}
