package dev.tttm.veterinerapp.api.controller;

import dev.tttm.veterinerapp.api.entity.Message;
import dev.tttm.veterinerapp.models.Owner;
import dev.tttm.veterinerapp.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/owners")
public class OwnerRestController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Owner>> getAll(){
        List<Owner> owners = ownerService.getAll();
        return ResponseEntity.ok(owners);
    }


    @PostMapping(path = {"","/"})
    public ResponseEntity<Message> create(@RequestBody Owner owner){
        ownerService.store(owner);
        return ResponseEntity.ok(new Message("Hayvan sahibi kaydedildi!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getById(@PathVariable("id") Long id){
        if(!ownerService.existById(id))
            return ResponseEntity.notFound().build();

        Owner owner = ownerService.getById(id);
        return ResponseEntity.ok(owner);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Message> delete(@PathVariable("id") Long id){
        if(!ownerService.existById(id))
            return ResponseEntity.notFound().build();

        ownerService.delete(id);
        return ResponseEntity.ok(new Message("Hayvan Sahibi Silindi!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> edit(@PathVariable("id") Long id, @RequestBody Owner owner){

        if(!ownerService.existById(id))
            return ResponseEntity.notFound().build();

        owner.setId(id);
        ownerService.store(owner);
        return ResponseEntity.ok(new Message("Hayvan sahibi güncellendi!"));
    }
}
