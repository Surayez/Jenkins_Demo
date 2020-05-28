package com.example.demo.repository;

import com.example.demo.entity.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    List<Comment> findByBlogId(String blogId);
    List<Comment> findByParent(int parent);
}
