package com.example.infrastructurespringdata.repository.impl;

import com.example.infrastructurespringdata.entity.PlantsEntity;
import com.example.infrastructurespringdata.exception.NotFoundException;
import com.example.infrastructurespringdata.repository.PlantsEntityRepository;
import org.example.entity.Plants;
import org.example.port.repository.PlantsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class PlantsRepositoryImpl implements PlantsRepository {

    private final PlantsEntityRepository plantsEntityRepository;
    private final ModelMapper modelMapper;

    public PlantsRepositoryImpl(PlantsEntityRepository reportEntityRepository, ModelMapper modelMapper) {
        this.plantsEntityRepository = reportEntityRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Plants save(Plants plants) {
        PlantsEntity plantsEntity = modelMapper.map(plants, PlantsEntity.class);
        return modelMapper.map(plantsEntityRepository.save(plantsEntity), Plants.class);
    }

    @Override
    public Plants findById(int id) {
        Optional<PlantsEntity> optionalPlantsEntity = Optional.ofNullable(plantsEntityRepository.findById(id));
        if(optionalPlantsEntity.isPresent()){
            return modelMapper.map(optionalPlantsEntity.get(), Plants.class);
        }
        throw new NotFoundException();
    }

    @Override
    public Plants update(Plants plants) {
        PlantsEntity plantsEntity = modelMapper.map(plants, PlantsEntity.class);
        return modelMapper.map(plantsEntityRepository.save(plantsEntity), Plants.class);
    }

    @Override
    public List<Plants> findAll() {
       return convertToListReports((List<PlantsEntity>) plantsEntityRepository.findAll());
    }

    @Override
    public void delete(Plants plants) {
        plantsEntityRepository.delete(modelMapper.map(plants, PlantsEntity.class));
    }

    //Convertir une liste de ReportEntity en Liste de Report
    private List<Plants> convertToListReports(List<PlantsEntity> plantsEntities) {
        List<Plants> plants = new ArrayList<>();
        plantsEntities.forEach(p ->plants.add(modelMapper.map(p, Plants.class)));
        return plants;
    }
}
