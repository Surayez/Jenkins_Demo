package com.example.demo.service;

import com.example.demo.entity.UserObject;

import java.util.List;

public interface UserService {
    public List<UserObject> retrieveAllUsers();
    public UserObject getUser(int userId);
    public void saveUser(UserObject user);
    public void deleteUser(int userId);
    public void updateUser(UserObject user, int userId);
}
