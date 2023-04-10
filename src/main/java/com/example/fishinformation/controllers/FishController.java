package com.example.fishinformation.controllers;

import com.example.fishinformation.models.Fish;
import com.example.fishinformation.repositories.FishRepository;
import com.example.fishinformation.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fish")
public class FishController {

    @Autowired
    private FishService service;

    @GetMapping
    public List<Fish> getAllFish() {
        return service.getAllFish();
    }

    @GetMapping("/{id}")
    public Fish getFishById(@PathVariable Long id) {
        return service.getFishById(id);
    }

    @GetMapping(params = {"commonName"})
    public Fish getFishByCommonName(String commonName) {
        return service.findByCommonNameOrOtherNames(commonName);
    }

    @GetMapping(params = {"scientificName"})
    public Fish getFishByScientificName(String scientificName) {
        String[] names = scientificName.split(" ");
        return service.findByScientificName(names[0], names[1]);
    }

    @PostMapping
    public Fish addFish(@RequestBody Fish newFish) {
        return service.addFish(newFish);
    }

    @PutMapping("/{id}")
    public Fish updateFish(@RequestBody Fish newFish, @PathVariable Long id) {
        return service.updateFish(newFish, id);
    }

    @DeleteMapping("/{id}")
    public void deleteFishById(@PathVariable Long id) {
        service.deleteFishById(id);
    }
}
