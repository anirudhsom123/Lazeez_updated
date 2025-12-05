package com.Lazeez.backend.Model;

import com.Lazeez.backend.Enum.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    @Column(unique = true,nullable = false)
    @Email
    private String email;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(length = 10)
    private String mobNo;

    @CreationTimestamp
    private Date createdAt;

    @OneToOne(mappedBy = "customer" , cascade = CascadeType.ALL)

    private Cart cart;

}
