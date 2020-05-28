package com.example.demo.service;

import com.example.demo.entity.UserObject;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplement implements UserService{

    @Autowired
    UserRepository userRepository;

    public List<UserObject> retrieveAllUsers() {
        return (List<UserObject>) userRepository.findAll();
    }


    public UserObject getUser(int userId) {
        Optional<UserObject> user = userRepository.findById(userId);
        return user.get();
    }

    public void saveUser(UserObject user) {
        Date currentDate = new Date();
        user.setCreatedAt(currentDate);
        user.setUpdatedAt(currentDate);
        userRepository.save(user);
    }


    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }


    public void updateUser(UserObject user, int userId){
        UserObject prevUser = getUser(userId);
        prevUser.setEmail(user.getEmail());
        prevUser.setFirst_name(user.getFirst_name());
        prevUser.setLast_name(user.getLast_name());
        prevUser.setUpdatedAt(new Date());
        userRepository.save(prevUser);
    }
}
