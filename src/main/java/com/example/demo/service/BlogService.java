package com.example.demo.service;

import com.example.demo.entity.BlogPost;

import java.util.List;

public interface BlogService {
    public List<BlogPost> retrieveAllBlog();
    public BlogPost getBlog(int blogId);
    public List<BlogPost> getBlogsByUserId(int userId);
    public void saveBlog(BlogPost blog);
    public void deleteBlog(int blogId);
    public void updateBlog(BlogPost blog, int blogId);

    // For Voting
    public void upvoteBlog(int blogId);
    public void downvoteBlog(int blogId);

    // For Pagination
    public List<BlogPost> retrieveAllPagedBlogs(int page, int size);
    public int getTotalPages(int size);
}