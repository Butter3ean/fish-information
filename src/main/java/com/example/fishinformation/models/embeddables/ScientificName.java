package com.example.fishinformation.models.embeddables;

import jakarta.persistence.Embeddable;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Embeddable
public class ScientificName {

    private String genus;
    private String species;

    public ScientificName() {
    }

    public ScientificName(String genus, String species) {
        this.genus = StringUtils.capitalize(genus);
        this.species = species.toLowerCase();
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = StringUtils.capitalize(genus);
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species.toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScientificName that = (ScientificName) o;
        return genus.equals(that.genus) && species.equals(that.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genus, species);
    }

    @Override
    public String toString() {
        return "ScientificName{" +
                "genus='" + genus + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}
