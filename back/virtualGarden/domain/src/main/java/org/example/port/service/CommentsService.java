package org.example.port.service;

import org.example.entity.Comments;

import java.util.List;

public interface CommentsService {


    Comments createComment(String comment, int plantId, int userId);

    Comments getCommentById(int id);

    Comments updateComment(int id, Comments comments);

    void deleteComment(int id);

    List<Comments> getAllComments();
}
