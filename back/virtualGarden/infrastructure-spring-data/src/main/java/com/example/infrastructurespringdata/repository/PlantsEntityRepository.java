package com.example.infrastructurespringdata.repository;


import com.example.infrastructurespringdata.entity.PlantsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantsEntityRepository  extends JpaRepository<PlantsEntity, Integer> {
    PlantsEntity save(PlantsEntity plantsEntity);
    PlantsEntity findById(int id);
    List<PlantsEntity> findAll();

    void delete(PlantsEntity plants);
}

