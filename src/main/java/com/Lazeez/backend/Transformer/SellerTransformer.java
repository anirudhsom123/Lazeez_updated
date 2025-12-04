package com.Lazeez.backend.Transformer;

import com.Lazeez.backend.DTO.Request.SellerRequest;
import com.Lazeez.backend.DTO.Response.SellerResponse;
import com.Lazeez.backend.Model.Seller;

public class SellerTransformer {

    public static Seller sellerRequestToSeller(SellerRequest sellerRequest){
        return Seller.builder()
                .name(sellerRequest.getName())
                .pan(sellerRequest.getPan())
                .email(sellerRequest.getEmail())
                .build();
    }

    public  static SellerResponse sellerToSellerResponse(Seller seller){
        return SellerResponse.builder()
                .name(seller.getName())
                .email(seller.getEmail())
                .build();
    }
}
