package org.example.port.service;

import org.example.entity.Plants;
import org.example.entity.enumeration.PlantsDryingLevel;

import java.util.List;

public interface PlantsService {

    Plants createPlants(Plants plants);

    Plants getPlantsById(int id);

    Plants updatePlants(int id, Plants plants);

    void deletePlants(int id);

    List<Plants> getAllPlants();

}
