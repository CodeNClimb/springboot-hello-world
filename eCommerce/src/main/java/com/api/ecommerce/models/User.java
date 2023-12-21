package com.api.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @NotBlank(message = "username cannot be blank")
    @Column(name = "username", unique = true)
    private String username;

    @NonNull
    @NotBlank(message = "firstName cannot be blank")
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @NotBlank(message = "lastName cannot be blank")
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @NotBlank(message = "password cannot be blank")
    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NonNull
    @NotBlank(message = "address cannot be blank")
    @Column(name = "address")
    private String address;


    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Review> reviews;
    public User(String username, String firstName, String lastName, String password, String address) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
    }


}
