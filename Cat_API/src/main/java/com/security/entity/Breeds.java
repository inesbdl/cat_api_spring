package com.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Breeds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String idBreed;
    private String name;
    private String lifespan;
    private String origin;
    private String country_code;
    private String wikipedia_url;


    @ManyToMany(mappedBy="breeds")
    @JsonIgnore
    List<Cats> cats;
}