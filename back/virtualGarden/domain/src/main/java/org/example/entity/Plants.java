package org.example.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.example.entity.enumeration.PlantsDryingLevel;

public class Plants {

    private int id;

    private String name;

    private String description;

    private String image;

    private String scientificName;

    private String family;

@Enumerated(EnumType.STRING)
    private PlantsDryingLevel plantsDryingLevel;


    public Plants() {

    }

    public Plants(int id, String name, String description, String image, String scientificName, String family, PlantsDryingLevel plantsDryingLeveldryingLevel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.scientificName = scientificName;
        this.family = family;
        this.plantsDryingLevel = plantsDryingLevel;
    }

    public Plants(String name, String description, String image, String scientificName, String family,  PlantsDryingLevel plantsDryingLevel) {

        this.name = name;
        this.description = description;
        this.image = image;
        this.scientificName = scientificName;
        this.family = family;
        this.plantsDryingLevel = plantsDryingLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public PlantsDryingLevel getPlantsDryingLevel() {
        return plantsDryingLevel;
    }

    public void setPlantsDryingLevel(PlantsDryingLevel plantsDryingLevel) {
        this.plantsDryingLevel = plantsDryingLevel;
    }

    @Override
    public String toString() {
        return "Plants{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", scientificName='" + scientificName + '\'' +
                ", family='" + family + '\'' +
                ", plantsDryingLevel=" + plantsDryingLevel +
                '}';
    }
}
