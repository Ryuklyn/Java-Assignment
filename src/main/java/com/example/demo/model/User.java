package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public  class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private  long id;
    private String username;

    @Column (name = "is_premium")
    private boolean isPremium;
}