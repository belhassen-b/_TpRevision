package com.example.apirest.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.enumeration.PlantsDryingLevel;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlantsRequestDTO {
    private String plantsName;
    private String plantsDescription;
    private String plantsImage;
    private String plantsScientificName;
    private String plantsFamily;
    private PlantsDryingLevel plantsDryingLevel;
}
