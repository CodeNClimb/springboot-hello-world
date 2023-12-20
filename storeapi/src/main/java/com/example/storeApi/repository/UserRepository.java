package com.example.storeApi.repository;

import com.example.storeApi.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    void deleteById(int id);

}
