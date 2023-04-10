package com.example.fishinformation.repositories;

import com.example.fishinformation.models.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FishRepository extends JpaRepository<Fish, Long> {
    public Fish findByCommonName(String commonName);
    public Fish findByScientificNameGenusAndScientificNameSpecies(String genus, String species);
    @Query("SELECT f FROM Fish f WHERE f.commonName = :name OR :name IN (SELECT o FROM f.otherNames o)")
    public Fish findByCommonNameOrOtherNames(String name);

}
