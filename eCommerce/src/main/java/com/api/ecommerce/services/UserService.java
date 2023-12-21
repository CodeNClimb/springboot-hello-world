package com.api.ecommerce.services;

import com.api.ecommerce.models.User;

import java.util.List;

public interface UserService {
    User getUser(int id);
    List<User> getAllUsers();
    void deleteUser(int id);
    void addUser(User user);
    void addUserToMemory(User u);
    User getUser(String username);



}
