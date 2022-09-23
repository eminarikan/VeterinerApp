package dev.tttm.veterinerapp.api.controller;

import dev.tttm.veterinerapp.api.entity.AddPetDto;
import dev.tttm.veterinerapp.api.entity.Message;
import dev.tttm.veterinerapp.models.Owner;
import dev.tttm.veterinerapp.models.Pet;
import dev.tttm.veterinerapp.services.OwnerService;
import dev.tttm.veterinerapp.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/owners/{ownerId}/pets")
public class OwnerPetRestController {
    @Autowired
    private PetService petService;
    @Autowired
    private OwnerService ownerService;

    @GetMapping(path = {"","/"})
    public ResponseEntity<List<Pet>> index(@PathVariable("ownerId") Long ownerId){
        if(!ownerService.existById(ownerId))
            return ResponseEntity.notFound().build();

        List<Pet> pets = ownerService.getById(ownerId).getPets();
        return ResponseEntity.ok(pets);
    }

    @GetMapping(path = {"/{petId}"})
    public ResponseEntity<Pet> getById(@PathVariable("ownerId") Long ownerId,
                                       @PathVariable("petId") Long petId){
        if(!ownerService.existById(ownerId))
            return ResponseEntity.notFound().build();

        if(!petService.existById(petId))
            return ResponseEntity.notFound().build();

        Pet pet = petService.getByIdAndOwnerId(petId, ownerId);

        return ResponseEntity.ok(pet);
    }

    @PostMapping(path = {"","/"})
    public ResponseEntity<Message> create(@PathVariable("ownerId") Long ownerId,
                                          @RequestBody AddPetDto petDto){
        if(!ownerService.existById(ownerId))
            return ResponseEntity.notFound().build();

        Owner owner = ownerService.getById(ownerId);
        petService.store(petDto, owner);
        return ResponseEntity.ok(new Message("Hayvan sisteme kaydedildi"));

    }

    @PutMapping(path = "/{petId}")
    public ResponseEntity<Message> update(@PathVariable("ownerId") Long ownerId,
                                          @PathVariable("petId") Long petId,
                                          @RequestBody AddPetDto petDto){
        if(!ownerService.existById(ownerId))
            return ResponseEntity.notFound().build();

        if(!petService.existById(petId))
            return ResponseEntity.notFound().build();

        Owner owner = ownerService.getById(ownerId);
        Pet pet = petService.getById(petId);
        pet.update(petDto);
        petService.store(owner, pet);
        return ResponseEntity.ok(new Message("Hayvan güncellendi!"));
    }

    @DeleteMapping(path="/{petId}")
    public ResponseEntity<Message> delete(@PathVariable("ownerId") Long ownerId,
                                          @PathVariable("petId") Long petId){

        if(!ownerService.existById(ownerId))
            return ResponseEntity.notFound().build();

        if(!petService.existById(petId))
            return ResponseEntity.notFound().build();

        petService.delete(petId);
        return ResponseEntity.ok(new Message("Hayvan silindi!"));
    }
}
