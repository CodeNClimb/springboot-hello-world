package com.api.ecommerce.exceptions;

public class CategoryNotUniqueException extends RuntimeException {

    public CategoryNotUniqueException(String category) {
        super("The Category with title '" + category + "' already exists. Please choose a unique category title.");
    }

}
