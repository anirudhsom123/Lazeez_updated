package com.Lazeez.backend.Transformer;

import com.Lazeez.backend.DTO.Request.ProductRequest;
import com.Lazeez.backend.DTO.Response.ProductResponse;
import com.Lazeez.backend.Model.Product;

public class ProductTransformer {

    public  static Product productRequestToProduct(ProductRequest productRequest){

        return Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .category(productRequest.getCategory())
                .build();
    }

    public static ProductResponse productToProductResponse(Product product){
        return ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .category(product.getCategory())
                .seller(SellerTransformer.sellerToSellerResponse(product.getSeller()))
                .build();
    }
}
