package com.example.storeApi.services;

import com.example.storeApi.models.User;

import java.util.List;

public interface UserService {
    User getUser(int id);
    List<User> getAllUsers();
    void deleteUser(int id);
    void addUser(User user);

}
