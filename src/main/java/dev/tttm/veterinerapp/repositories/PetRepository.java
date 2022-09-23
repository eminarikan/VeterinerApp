package dev.tttm.veterinerapp.repositories;

import dev.tttm.veterinerapp.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    @Query("SELECT p from Pet p where p.name like %?1%")
    public List<Pet> search(String keyword);

    @Query("SELECT p from Pet p WHERE p.id = :petId AND owner_id = :ownerId")
    Pet getByIdAndOwnerId(@Param("petId") Long petId, @Param("ownerId") Long ownerId);
}
