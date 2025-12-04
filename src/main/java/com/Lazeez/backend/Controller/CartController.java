package com.Lazeez.backend.Controller;

import com.Lazeez.backend.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping
    public ResponseEntity addToCart(@RequestParam("id") int id){

        return new ResponseEntity(cartService.addToCart(id) , HttpStatus.OK);

    }
}
