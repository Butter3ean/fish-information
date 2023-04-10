package com.example.fishinformation.service;

import com.example.fishinformation.models.Fish;
import com.example.fishinformation.repositories.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishServiceImpl implements FishService {

    @Autowired
    private FishRepository repository;

    @Override
    public Fish addFish(Fish newFish) {
        return repository.save(newFish);
    }

    @Override
    public List<Fish> getAllFish() {
        return repository.findAll();
    }

    @Override
    public Fish getFishById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void deleteFishById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Fish updateFish(Fish newFish, Long id) {
        return repository.findById(id)
                .map(fish -> {
                    fish.setScientificName(newFish.getScientificName());
                    fish.setCommonName(newFish.getCommonName());
                    fish.setOtherNames(newFish.getOtherNames());
                    fish.setDescription(newFish.getDescription());
                    fish.setImageUrl(newFish.getImageUrl());
                    return repository.save(fish);
                })
                .orElseGet(() -> {
                    newFish.setId(id);
                    return repository.save(newFish);
                });
    }

    @Override
    public Fish findByScientificName(String genus, String species) {
        return repository.findByScientificNameGenusAndScientificNameSpecies(genus, species);
    }

    @Override
    public Fish findByCommonNameOrOtherNames(String name) {
        return repository.findByCommonNameOrOtherNames(name);
    }
}
