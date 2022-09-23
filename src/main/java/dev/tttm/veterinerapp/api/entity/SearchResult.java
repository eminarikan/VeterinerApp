package dev.tttm.veterinerapp.api.entity;

import dev.tttm.veterinerapp.models.Owner;
import dev.tttm.veterinerapp.models.Pet;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {
    private List<Owner> ownersFound;
    private List<Pet> petsFound;

    public SearchResult(List<Owner> ownersFound, List<Pet> petsFound) {
        this.ownersFound = ownersFound;
        this.petsFound = petsFound;
    }

    public List<Owner> getOwners() {
        return ownersFound;
    }

    public void setOwners(List<Owner> ownersFound) {
        this.ownersFound = ownersFound;
    }

    public List<Pet> getPets() {
        return petsFound;
    }

    public void setPets(List<Pet> petsFound) {
        this.petsFound = petsFound;
    }
}
