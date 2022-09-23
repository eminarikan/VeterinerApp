package dev.tttm.veterinerapp.api.controller;

import dev.tttm.veterinerapp.api.entity.SearchResult;
import dev.tttm.veterinerapp.models.Owner;
import dev.tttm.veterinerapp.models.Pet;
import dev.tttm.veterinerapp.services.OwnerService;
import dev.tttm.veterinerapp.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchRestController {
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private PetService petService;

    @GetMapping(path = "/api/search")
    public ResponseEntity<SearchResult> search(@Param("key") String key){
        List<Owner> owners = ownerService.search(key);
        List<Pet> pets = petService.search(key);
        return ResponseEntity.ok(new SearchResult(owners, pets));
    }
}
