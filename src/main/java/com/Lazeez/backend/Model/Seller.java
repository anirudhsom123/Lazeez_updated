package com.Lazeez.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(length = 10,unique = true)
    private String pan;

    @Column
    private String email;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Product> products = new ArrayList<>();
}
