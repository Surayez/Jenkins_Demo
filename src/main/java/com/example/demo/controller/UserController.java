package com.example.demo.controller;

import com.example.demo.entity.BlogPost;
import com.example.demo.entity.UserObject;
import com.example.demo.service.BlogService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class.getName());

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


    // USER API SECTION

    @GetMapping("/user")
    private List<UserObject> getAllUsers() {
        return userService.retrieveAllUsers();
    }

    @GetMapping("/user/{id}")
    private UserObject getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/user/{id}")
    private void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }

    @PostMapping("/user")
    private int saveUser(UserObject user) {
        userService.saveUser(user);
        return user.getUserId();
    }

    @PostMapping("/user/{id}")
    private int updateUser(@PathVariable("id") int id, UserObject user) {
        userService.updateUser(user, id);
        return user.getUserId();
    }

    @PostMapping("/userBlogs/{id}")
    private List<BlogPost> getUserBlogs(@PathVariable("id") int id) {
        return blogService.getBlogsByUserId(id);
    }
}