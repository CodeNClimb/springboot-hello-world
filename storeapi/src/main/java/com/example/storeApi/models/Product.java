package com.example.storeApi.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "desc")
    private String description;

    @NonNull
    @Column(name = "image")
    private String image;

    @ManyToMany
    @JoinTable(
            name = "user_products",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn( name = "product_id", referencedColumnName = "id")
    )
    private Set<User> users;

    @OneToMany(mappedBy = "product", cascade =  CascadeType.ALL)
    private Set<Review> reviews;
}
