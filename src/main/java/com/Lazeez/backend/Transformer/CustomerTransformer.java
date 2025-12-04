package com.Lazeez.backend.Transformer;

import com.Lazeez.backend.DTO.Request.CustomerRequest;
import com.Lazeez.backend.DTO.Response.CustomerResponse;
import com.Lazeez.backend.Model.Customer;

public class CustomerTransformer {

    public  static Customer customerRequestToCustomer(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .email(customerRequest.getEmail())
                .mobNo(customerRequest.getMobNo())
                .gender(customerRequest.getGender())
                .build();
    }

    public  static CustomerResponse customerToCustomerResponse(Customer customer){
        return CustomerResponse.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .mobNo(customer.getMobNo())
                .email(customer.getEmail())
                .gender(customer.getGender())
                .cart(customer.getCart())
                .build();
    }
}
