package com.Lazeez.backend.Service;

import com.Lazeez.backend.Exception.ProductDoNotExist;
import com.Lazeez.backend.Model.Product;
import com.Lazeez.backend.Repository.CartRepository;
import com.Lazeez.backend.Repository.ProductRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {


    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;


    private ChatClient chatClient;

    public CartService(ChatClient.Builder builder){

        this.chatClient= builder.build();

    }


    public String addToCart(int id) {

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {

            throw new ProductDoNotExist("product with id " + id + " dont exist");
        }

        Product product = optionalProduct.get();

        // DTO -> Entity

        var res = chatClient.prompt("sum of 2 random numbers")
                .call()
                .content();

        return res;
    }
}
