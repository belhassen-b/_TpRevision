package org.example.service;

import org.example.entity.Plants;
import org.example.entity.enumeration.PlantsDryingLevel;
import org.example.port.repository.PlantsRepository;
import org.example.port.service.PlantsService;

import java.util.List;

public class PlantsServiceImpl implements PlantsService {

    private PlantsRepository plantsRepository;

    public PlantsServiceImpl(PlantsRepository plantsRepository) {
        this.plantsRepository = plantsRepository;
    }

    @Override
    public Plants createPlants(Plants plants) {
        return plantsRepository.save(plants);
    }
    @Override
    public Plants getPlantsById(int id) {
        return plantsRepository.findById(id);
    }

    @Override
    public Plants updatePlants(int id, Plants plants) {
        try {
            Plants oldPlants = getPlantsById(id);
            oldPlants.setName(plants.getName());
            oldPlants.setDescription(plants.getDescription());
            oldPlants.setImage(plants.getImage());
            oldPlants.setScientificName(plants.getScientificName());
            oldPlants.setFamily(plants.getFamily());
            oldPlants.setPlantsDryingLevel(plants.getPlantsDryingLevel())  ;
            return plantsRepository.update(oldPlants);
        }
        catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void deletePlants(int id) {
        try {
            Plants plants = getPlantsById(id);
            plantsRepository.delete(plants);
        }
        catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<Plants> getAllPlants() {
        return null;
    }
}
