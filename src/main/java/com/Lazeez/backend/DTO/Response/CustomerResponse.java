package com.Lazeez.backend.DTO.Response;

import com.Lazeez.backend.Enum.Gender;
import com.Lazeez.backend.Model.Cart;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CustomerResponse {

    private String name;

    private int age;

    private String email;

    private Gender gender;

    private String mobNo;

    private Cart cart;
}
