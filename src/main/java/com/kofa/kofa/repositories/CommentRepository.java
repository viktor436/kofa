package com.kofa.kofa.repositories;

import com.kofa.kofa.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findAllByProductName(String name);
}
