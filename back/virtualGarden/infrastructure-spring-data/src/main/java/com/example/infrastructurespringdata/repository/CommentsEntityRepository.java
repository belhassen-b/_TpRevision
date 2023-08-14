package com.example.infrastructurespringdata.repository;

import com.example.infrastructurespringdata.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsEntityRepository extends JpaRepository<CommentsEntity, Integer> {
}
