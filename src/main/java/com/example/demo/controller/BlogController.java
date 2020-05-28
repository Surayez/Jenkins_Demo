package com.example.demo.controller;

import com.example.demo.entity.BlogPost;
import com.example.demo.entity.UserObject;
import com.example.demo.service.BlogService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class BlogController {
    private static final Logger logger = Logger.getLogger(BlogController.class.getName());

    @Autowired
    private BlogService blogService;
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    @Autowired
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    // BLOG API SECTION

    @GetMapping("/blog")
    private List<BlogPost> getAllBlog() {
        return blogService.retrieveAllBlog();
    }

    @GetMapping("/blog/{id}")
    private BlogPost getBlog(@PathVariable("id") int id) {
        return blogService.getBlog(id);
    }

    @DeleteMapping("/blog/{id}")
    private void deleteblog(@PathVariable("id") int id) {
        blogService.deleteBlog(id);
    }

    @PostMapping("/blog")
    private int saveBlog(BlogPost blog) {
        try {
            if (blog.getUserId() != 0) {
                UserObject user = userService.getUser(blog.getUserId());
                blog.setEmail(user.getEmail());
                blog.setFirst_name(user.getFirst_name());
                blog.setLast_name(user.getLast_name());
            }
            blogService.saveBlog(blog);
            return blog.getBlogId();
        }
        catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to save blog as no such user exists.");
            return 0;
        }
    }

    @PostMapping("/blog/{id}")
    private int updateBlog(@PathVariable("id") int id, BlogPost blog) {
        blogService.updateBlog(blog, id);
        return blog.getBlogId();
    }

    @PostMapping("/blogUp/{id}")
    private int upvoteBlog(@PathVariable("id") int id) {
        try{
            blogService.upvoteBlog(id);
            return 1;
        }
        catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to upvote as no such blog exists.");
            return 0;
        }
    }

    @PostMapping("/blogDown/{id}")
    private int downVote(@PathVariable("id") int id) {
        try{
            blogService.downvoteBlog(id);
            return 1;
        }
        catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to upvote as no such blog exists.");
            return 0;
        }
    }

    // BLOG PAGINATION

    @GetMapping("/blogPaginated/{size}")
    private int getTotalBlogPages(@RequestParam("size") int size) {
        return blogService.getTotalPages(size);
    }

    @GetMapping("/blogPaginated/{size}/{page}")
    private List<BlogPost> getPaginatedBlog(@RequestParam("size") int size, @RequestParam("page") int page) {
        return blogService.retrieveAllPagedBlogs(page, size);
    }

}