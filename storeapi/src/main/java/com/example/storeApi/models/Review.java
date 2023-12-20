package com.example.storeApi.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @NonNull
    @Column(name = "title" , nullable = false)
    private String title;

    @NonNull
    @Column(name = "review_text", nullable = false)
    private String text;

    @NonNull
    @Column(name = "rating", nullable = false)
    private int rating;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
