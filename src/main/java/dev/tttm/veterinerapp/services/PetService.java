package dev.tttm.veterinerapp.services;

import dev.tttm.veterinerapp.api.entity.AddPetDto;
import dev.tttm.veterinerapp.models.Owner;
import dev.tttm.veterinerapp.models.Pet;

import java.util.List;

public interface PetService {
    void store(Owner owner, Pet pet);
    Pet getById(Long id);
    void delete(Long id);
    List<Pet> search(String keyword);
    List<Pet> getAll();
    Long count();

    Pet getByIdAndOwnerId(Long petId, Long ownerId);

    void store(AddPetDto petDto, Owner owner);

    boolean existById(Long id);
}
