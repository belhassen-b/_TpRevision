package org.example.port.repository;

import org.example.entity.Comments;

import java.util.List;

public interface CommentsRepository {

    Comments save(Comments comments);

    Comments findById(int id);

    Comments update(Comments comments);

    void delete(Comments comments);

    List<Comments> findAll();
}
