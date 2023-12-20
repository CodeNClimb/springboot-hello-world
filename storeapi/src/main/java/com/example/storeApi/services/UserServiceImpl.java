package com.example.storeApi.services;

import com.example.storeApi.exceptions.EntityNotFoundException;
import com.example.storeApi.models.User;
import com.example.storeApi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Override
    public User getUser(int id) {
        return unwrapUser(userRepository.findById(id), id);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }


    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    public static User unwrapUser(Optional<User> optionalUser, int userId) {
        User user =  optionalUser.orElse(null);
        if (user == null) {
            throw new EntityNotFoundException(new User(), userId);
        }
        return user;
    }

}
