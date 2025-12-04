package com.Lazeez.backend.DTO.Response;

import com.Lazeez.backend.Enum.Category;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProductResponse {

    private String name;

    private int price;

    private Category category;

    private  SellerResponse seller;
}
