package com.Lazeez.backend.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.core.publisher.Flux;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {

    private CustomerResponse customer ;

    private List<ProductResponse> products;

    private String recepie;
}
