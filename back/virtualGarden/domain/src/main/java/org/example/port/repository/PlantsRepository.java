package org.example.port.repository;

import org.example.entity.Plants;

import java.util.List;

public interface PlantsRepository {

    Plants save(Plants plants);
    Plants findById(int id);
    Plants update(Plants plants);
    void delete(Plants plants);
    List<Plants> findAll();
}
