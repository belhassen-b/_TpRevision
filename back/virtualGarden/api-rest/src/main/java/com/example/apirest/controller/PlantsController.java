package com.example.apirest.controller;


import com.example.apirest.dto.request.PlantsRequestDTO;
import com.example.apirest.dto.response.PlantsResponseDTO;
import org.example.entity.Plants;
import org.example.port.service.PlantsService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/plants")
@RestController
public class PlantsController {

    private final PlantsService plantsService;

    private final ModelMapper modelMapper;

    public PlantsController(PlantsService plantsService, ModelMapper modelMapper) {
        this.plantsService = plantsService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public ResponseEntity<PlantsResponseDTO> post(@RequestBody PlantsRequestDTO plantsRequestDTO) {
        System.out.println(plantsRequestDTO);
        Plants plants = modelMapper.map(
                plantsRequestDTO, Plants.class
        );
        plantsService.createPlants(plants);
        return ResponseEntity.ok( new PlantsResponseDTO());
    }

    @GetMapping("")
    public ResponseEntity<List<PlantsResponseDTO>> get() {
        return ResponseEntity.ok(convertToListPlants(plantsService.getAllPlants()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantsResponseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(modelMapper.map(plantsService.getPlantsById(id), PlantsResponseDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlantsResponseDTO> put(@PathVariable int id, @RequestBody PlantsRequestDTO plantsRequestDTO) {
        return  ResponseEntity.ok(
                modelMapper.map(
                        plantsService.updatePlants(
                                id,
                                modelMapper.map(plantsRequestDTO, Plants.class)),
                        PlantsResponseDTO.class)
        );
    }

    private List<PlantsResponseDTO> convertToListPlants(List<Plants> allPlants) {
        List<PlantsResponseDTO> plantsResponseDTOS = new ArrayList<>();
        for (Plants plants : allPlants) {
            plantsResponseDTOS.add(modelMapper.map(plants, PlantsResponseDTO.class));
        }
        return plantsResponseDTOS;
    }

}
