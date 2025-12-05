package com.Lazeez.backend.Service;

import com.Lazeez.backend.DTO.Response.CartResponse;
import com.Lazeez.backend.DTO.Response.CustomerResponse;
import com.Lazeez.backend.DTO.Response.ProductResponse;
import com.Lazeez.backend.Exception.CustomerDoNotExist;
import com.Lazeez.backend.Exception.ProductDoNotExist;
import com.Lazeez.backend.Model.Cart;
import com.Lazeez.backend.Model.Customer;
import com.Lazeez.backend.Model.Product;
import com.Lazeez.backend.Repository.CartRepository;
import com.Lazeez.backend.Repository.CustomerRepository;
import com.Lazeez.backend.Repository.ProductRepository;
import com.Lazeez.backend.Transformer.CustomerTransformer;
import com.Lazeez.backend.Transformer.ProductTransformer;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {


    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;


    private ChatClient chatClient;

    public CartService(ChatClient.Builder builder){

        this.chatClient= builder.build();

    }


    public CartResponse addToCart(int cid, int pid) {

        Optional<Customer> optionalCustomer = customerRepository.findById(cid);
        if (optionalCustomer.isEmpty()) {
            throw new CustomerDoNotExist("no customer with id " + cid + " exist");
        }

        Optional<Product> optionalProduct = productRepository.findById(pid);
        if (optionalProduct.isEmpty()) {
            throw new ProductDoNotExist("product with id " + pid + " dont exist");
        }

        Customer customer = optionalCustomer.get();
        Product product = optionalProduct.get();

        Cart cart = customer.getCart();
        if (cart == null) {
            cart = new Cart();
            cart.setCustomer(customer); // Set the relationship
            customer.setCart(cart); // Update customer's cart reference
        }

        List<Product> products = cart.getProducts();
        if (products == null) {
            products = new ArrayList<>();
            cart.setProducts(products);
        }
         products.add(product);


        cartRepository.save(cart);

        List<Product> products1 = productRepository.findAllByCart(cart);

        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product p : products1) {
            productResponses.add(ProductTransformer.productToProductResponse(p));
        }

        CustomerResponse customerResponse = CustomerTransformer.customerToCustomerResponse(customer);

        var res = chatClient.prompt("sum of 2 random numbers")
                .call()
                .content();

        CartResponse cartResponse = new CartResponse();
        cartResponse.setCustomer(customerResponse);
        cartResponse.setProducts(productResponses);
        cartResponse.setRecepie(res);

        return cartResponse;
    }

}
