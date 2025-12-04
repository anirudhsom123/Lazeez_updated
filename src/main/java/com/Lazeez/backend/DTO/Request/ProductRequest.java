package com.Lazeez.backend.DTO.Request;

import com.Lazeez.backend.Enum.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductRequest {

    private String name;

    private int price;

    private Category category;
}
