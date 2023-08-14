package org.example.service;

import org.example.entity.Comments;
import org.example.port.repository.CommentsRepository;
import org.example.port.service.CommentsService;

import java.util.List;

public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;

    public CommentsServiceImpl(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }


    @Override
    public Comments createComment(String comment, int plantId, int userId) {
        Comments comments = new Comments(comment, plantId, userId);
        return commentsRepository.save(comments);
    }

    @Override
    public Comments getCommentById(int id) {
        return commentsRepository.findById(id);
    }

    @Override
    public Comments updateComment(int id, Comments comments) {
        try {
            Comments comments1 = commentsRepository.findById(id);
            comments1.setComment(comments.getComment());
            comments1.setPlants(comments.getPlants());
            comments1.setUserApp(comments.getUserApp());
            return commentsRepository.save(comments1);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteComment(int id) {
        try {
            Comments comments = commentsRepository.findById(id);
            commentsRepository.delete(comments);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public List<Comments> getAllComments() {
        return commentsRepository.findAll();
    }
}
