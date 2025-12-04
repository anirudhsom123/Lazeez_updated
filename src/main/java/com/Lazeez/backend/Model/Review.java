package com.Lazeez.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Review {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String comment;

    @Min(value = 1)
    @Max(value = 5)
    @Column
    private int rating;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="customer_id")
    @JsonManagedReference
    Customer customer;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="product_id")
    @JsonIgnore
    Product product;
}
