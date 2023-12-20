package com.example.storeApi.models;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
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
    @Column(name = "username")
    private String username;

    @NonNull
    @NotBlank(message = "firstName cannot be blank")
    @Column(name = "firstName")
    private String firstName;

    @NonNull
    @NotBlank(message = "lastName cannot be blank")
    @Column(name = "lastName")
    private String lastName;

    @NonNull
    @NotBlank(message = "password cannot be blank")
    @Column(name = "password")
    private String password;

    @NonNull
    @NotBlank(message = "address cannot be blank")
    @Column(name = "address")
    private String address;

    @ManyToMany
    @JoinTable(
            name = "user_products",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn( name = "product_id", referencedColumnName = "id")
    )
    private Set<Product> products;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Review> reviews;



}
