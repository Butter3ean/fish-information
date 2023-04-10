package com.example.fishinformation.models;

import com.example.fishinformation.models.embeddables.ScientificName;
import jakarta.persistence.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Fish {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private ScientificName scientificName;
    private String commonName;
    @ElementCollection
    @CollectionTable(name = "fish_other_names", joinColumns = @JoinColumn(name = "fish_id"))
    private List<String> otherNames = new ArrayList<>();
    private String description;
    private URI imageUrl;

    public Fish() {
    }

    public Fish(Long id, ScientificName scientificName, String commonName, List<String> otherNames, String description, URI imageUrl) {
        this.id = id;
        this.scientificName = scientificName;
        this.commonName = commonName;
        this.otherNames = otherNames;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ScientificName getScientificName() {
        return scientificName;
    }

    public void setScientificName(ScientificName scientificName) {
        this.scientificName = scientificName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public List<String> getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(List<String> otherNames) {
        this.otherNames = otherNames;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URI getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(URI imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fish fish = (Fish) o;
        return id.equals(fish.id) && scientificName.equals(fish.scientificName) && commonName.equals(fish.commonName) && otherNames.equals(fish.otherNames) && description.equals(fish.description) && imageUrl.equals(fish.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, scientificName, commonName, otherNames, description, imageUrl);
    }

    @Override
    public String toString() {
        return "Fish{" +
                "id=" + id +
                ", scientificName=" + scientificName +
                ", commonName='" + commonName + '\'' +
                ", otherNames=" + otherNames +
                ", description='" + description + '\'' +
                ", imageUrl=" + imageUrl +
                '}';
    }
}
