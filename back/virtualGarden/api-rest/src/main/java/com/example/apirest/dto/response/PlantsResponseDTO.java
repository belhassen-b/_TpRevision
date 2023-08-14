package com.example.apirest.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.enumeration.PlantsDryingLevel;

@Builder
@NoArgsConstructor
@AllArgsConstructor@Data
public class PlantsResponseDTO {
    private int id;
    private String plantsName;
    private String plantsDescription;
    private String plantsImage;
    private String plantsScientificName;
    private String plantsFamily;
    private PlantsDryingLevel plantsDryingLevel;
}
