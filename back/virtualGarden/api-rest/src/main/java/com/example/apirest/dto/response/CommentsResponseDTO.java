package com.example.apirest.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsResponseDTO {
    private int id;
    private String comment;
    private int idReport;
    private int idPlant;
    private int idUser;
}
