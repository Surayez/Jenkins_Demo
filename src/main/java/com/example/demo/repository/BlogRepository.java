package com.example.demo.repository;

import com.example.demo.entity.BlogPost;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogRepository extends CrudRepository<BlogPost, Integer> {
    List<BlogPost> findByUserId(int userId);
}
