package com.Lazeez.backend.Model;

import com.Lazeez.backend.Enum.Category;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Product {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name="seller_id")
    private Seller seller;



    @ManyToMany(mappedBy = "products")
    private List<OrderEntity> orders = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Cart> cart;
}
