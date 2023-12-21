package com.api.ecommerce.exceptions;

public class UsernameNotUniqueException extends  RuntimeException{

    public UsernameNotUniqueException(String username) {
        super("The User with username '" + username + "' already exists. Please choose a unique username.");
    }
}
