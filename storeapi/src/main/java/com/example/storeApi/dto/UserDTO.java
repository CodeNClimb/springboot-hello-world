package com.example.storeApi.dto;

import com.example.storeApi.models.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String firstName;
    private String lasName;
    private String address;

}
