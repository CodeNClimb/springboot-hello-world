package com.api.ecommerce.repository;

import com.api.ecommerce.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {
    void deleteById(int id);
    User findByUsername(String username);

}
