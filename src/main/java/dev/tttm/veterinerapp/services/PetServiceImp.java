package dev.tttm.veterinerapp.services;

import dev.tttm.veterinerapp.api.entity.AddPetDto;
import dev.tttm.veterinerapp.models.Owner;
import dev.tttm.veterinerapp.models.Pet;
import dev.tttm.veterinerapp.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("petService")
public class PetServiceImp implements PetService{
    @Autowired
    private PetRepository petRepository;

    @Override
    public void store(Owner owner, Pet pet) {
        System.out.println(owner);
        pet.setOwner(owner);
        petRepository.save(pet);
    }

    @Override
    public Pet getById(Long id) {
        return petRepository.getById(id);
    }

    @Override
    public void delete(Long id) {
        petRepository.delete(petRepository.getById(id));
    }

    @Override
    public List<Pet> search(String keyword) {
        if (keyword != null && keyword.length() > 2) {
            return petRepository.search(keyword);
        }
        return null;
    }

    @Override
    public List<Pet> getAll() {
        return petRepository.findAll();
    }

    @Override
    public Long count() {
        return petRepository.count();
    }

    @Override
    public Pet getByIdAndOwnerId(Long petId, Long ownerId) {
        return petRepository.getByIdAndOwnerId(petId, ownerId);
    }

    @Override
    public void store(AddPetDto petDto, Owner owner) {
        Pet pet = Pet.from(petDto);
        this.store(owner, pet);
    }

    @Override
    public boolean existById(Long id) {
        return petRepository.existsById(id);
    }

}
