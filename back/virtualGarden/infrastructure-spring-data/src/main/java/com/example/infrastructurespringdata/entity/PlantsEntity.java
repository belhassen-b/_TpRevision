package com.example.infrastructurespringdata.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.enumeration.PlantsDryingLevel;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlantsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private String image;

    private String scientificName;

    private String family;

    @Enumerated(EnumType.STRING)

    private PlantsDryingLevel  plantsDryingLevel;


}
