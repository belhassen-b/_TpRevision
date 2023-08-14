package com.example.apirest.controller;


import com.example.apirest.dto.request.CommentsRequestDTO;
import com.example.apirest.dto.response.CommentsResponseDTO;
import org.example.entity.Comments;
import org.example.port.service.CommentsService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/comments")
@RestController
public class CommentsController {

    private final CommentsService commentsService;

    private final ModelMapper modelMapper;

    public CommentsController(CommentsService commentsService, ModelMapper modelMapper) {
        this.commentsService = commentsService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public ResponseEntity<CommentsResponseDTO> post(@RequestBody CommentsRequestDTO commentsRequestDTO) {
        return ResponseEntity.ok(modelMapper.map(commentsService.createComment(commentsRequestDTO.getComment(), commentsRequestDTO.getIdUser(), commentsRequestDTO.getIdPlant()), CommentsResponseDTO.class));
    }

    @GetMapping("")

    public ResponseEntity<List<CommentsResponseDTO>> get() {
        return ResponseEntity.ok(convertToListComments(commentsService.getAllComments()));
    }


    @GetMapping("/{id}")

    public ResponseEntity<CommentsResponseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(modelMapper.map(commentsService.getCommentById(id), CommentsResponseDTO.class));
    }

    @PutMapping("/{id}")

    public ResponseEntity<CommentsResponseDTO> put(@PathVariable int id, @RequestBody CommentsRequestDTO commentsRequestDTO) {
        return ResponseEntity.ok(modelMapper.map(commentsService.updateComment(id, modelMapper.map(commentsRequestDTO, Comments.class)), CommentsResponseDTO.class));
    }

    private List<CommentsResponseDTO> convertToListComments(List<Comments> allComments) {
        List<CommentsResponseDTO> commentsResponseDTOS = new ArrayList<>();
        for (Comments comments : allComments) {
            commentsResponseDTOS.add(modelMapper.map(comments, CommentsResponseDTO.class));
        }
        return commentsResponseDTOS;
    }
}
