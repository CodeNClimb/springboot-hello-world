package com.api.ecommerce.services;

import com.api.ecommerce.exceptions.EntityNotFoundException;
import com.api.ecommerce.exceptions.UsernameNotUniqueException;
import com.api.ecommerce.models.User;
import com.api.ecommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    InMemoryUserDetailsManager userDetailsManager;

    @Override
    public User getUser(int id) {
        return unwrapUser(userRepository.findById(id), id);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
        
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
        User u = userRepository.findByUsername(user.getUsername());
        if (u == null) {
            userRepository.save(user);
            addUserToMemory(user);
        }
        else{
            throw new UsernameNotUniqueException(user.getUsername());
        }

    }

    public static User unwrapUser(Optional<User> optionalUser, int userId) {
        User user =  optionalUser.orElse(null);
        if (user == null) {
            throw new EntityNotFoundException(new User(), userId);
        }
        return user;
    }
    @Override
    public  void addUserToMemory (User u) {
         userDetailsManager.createUser(
                org.springframework.security.core.userdetails.User.builder()
                        .username(u.getUsername())
                                .password(u.getPassword())
                        .roles("USER")
                        .build());
    }

}
