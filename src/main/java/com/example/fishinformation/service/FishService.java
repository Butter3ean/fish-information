package com.example.fishinformation.service;

import com.example.fishinformation.models.Fish;

import java.util.List;

public interface FishService {
    public Fish addFish(Fish newFish);
    public List<Fish> getAllFish();
    public Fish getFishById(Long id);
    public void deleteFishById(Long id);
    public Fish updateFish(Fish newFish, Long id);
    public Fish findByScientificName(String genus, String species);
    public Fish findByCommonNameOrOtherNames(String name);

}
