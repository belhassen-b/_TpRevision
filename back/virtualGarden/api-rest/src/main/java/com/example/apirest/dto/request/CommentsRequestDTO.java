package com.example.apirest.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsRequestDTO {

    private String comment;
    private int idReport;
    private int idPlant;
    private int idUser;
}
