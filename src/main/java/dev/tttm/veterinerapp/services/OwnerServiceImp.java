package dev.tttm.veterinerapp.services;

import dev.tttm.veterinerapp.models.Owner;
import dev.tttm.veterinerapp.models.Pet;
import dev.tttm.veterinerapp.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ownerService")
public class OwnerServiceImp implements OwnerService{
    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public void store(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner getById(Long id) {
        return ownerRepository.getById(id);
    }

    @Override
    public List<Pet> getOwnerPets(Owner owner) {
        return owner.getPets();
    }

    @Override
    public void delete(Long id) {
        ownerRepository.delete(ownerRepository.getById(id));
    }

    @Override
    public List<Owner> search(String keyword) {
        if (keyword != null && keyword.length() > 2) {
            return ownerRepository.search(keyword);
        }
        return null;
    }

    @Override
    public Long count() {
        return ownerRepository.count();
    }

    @Override
    public boolean existById(Long id) {
        return ownerRepository.existsById(id);
    }


}
