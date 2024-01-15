package com.api.ecommerce.controllers;

import com.api.ecommerce.dto.UserDTO;
import com.api.ecommerce.models.User;
import com.api.ecommerce.services.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User Controller", description = "Create Users who can access the eCommerce API.")
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserServiceImpl userService;
    @Operation(summary = "Returns the details of all the users in the database")
    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @Operation(summary = "Creates and stores a user in the database")
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User u) {
        userService.addUser(u);
        return new ResponseEntity<>(u.getUsername() + " successfully registered.", HttpStatus.CREATED);
    }
    @Operation(summary = "Retrieve a user with the specified ID")
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int id) {
        User u = userService.getUser(id);
        return new ResponseEntity<>(new UserDTO(u.getFirstName(), u.getLastName(), u.getAddress()), HttpStatus.OK);
    }
    @Operation(summary = "Delete a user with the specified ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
