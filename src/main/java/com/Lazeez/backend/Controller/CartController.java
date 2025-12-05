package com.Lazeez.backend.Controller;

import com.Lazeez.backend.DTO.Response.CartResponse;
import com.Lazeez.backend.Exception.CustomerDoNotExist;
import com.Lazeez.backend.Exception.ProductDoNotExist;
import com.Lazeez.backend.Model.Cart;
import com.Lazeez.backend.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping
    public ResponseEntity<CartResponse> addToCart(@RequestParam("cid") int cid,
                                          @RequestParam("pid") int pid){

        try{

            return new ResponseEntity(cartService.addToCart(cid,pid) , HttpStatus.OK);
        }catch (CustomerDoNotExist e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }catch (ProductDoNotExist e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }



    }
}
