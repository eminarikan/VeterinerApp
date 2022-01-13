package dev.tttm.veterinerapp.repositories;

import dev.tttm.veterinerapp.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    @Query("SELECT o from Owner o where o.firstName like %?1%")
    public List<Owner> search(String keyword);
}
