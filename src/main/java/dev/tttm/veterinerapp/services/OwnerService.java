package dev.tttm.veterinerapp.services;

import dev.tttm.veterinerapp.models.Owner;
import dev.tttm.veterinerapp.models.Pet;

import java.util.List;

public interface OwnerService {
    void store(Owner owner);
    List<Owner> getAll();
    Owner getById(Long id);
    List<Pet> getOwnerPets(Owner owner);
    void delete(Long id);
    List<Owner> search(String keyword);
    Long count();

    boolean existById(Long id);
}
