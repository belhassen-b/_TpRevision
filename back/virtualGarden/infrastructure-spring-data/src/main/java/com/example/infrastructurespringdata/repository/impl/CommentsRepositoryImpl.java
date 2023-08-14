package com.example.infrastructurespringdata.repository.impl;


import org.example.entity.Comments;
import org.example.port.repository.CommentsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentsRepositoryImpl implements CommentsRepository {
    @Override
    public Comments save(Comments comments) {
        return null;
    }

    @Override
    public Comments findById(int id) {
        return null;
    }

    @Override
    public Comments update(Comments comments) {
        return null;
    }

    @Override
    public void delete(Comments comments) {

    }

    @Override
    public List<Comments> findAll() {
        return null;
    }
}
