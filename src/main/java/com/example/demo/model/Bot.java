package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Bot {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;

    @Column (name = "personal_description")
    private String personalDescription;
}
