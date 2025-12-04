package com.Lazeez.backend.Controller;

import com.Lazeez.backend.DTO.Request.ProductRequest;
import com.Lazeez.backend.Exception.ProductDoNotExist;
import com.Lazeez.backend.Exception.SellerDoNotExist;
import com.Lazeez.backend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity addProduct(@RequestParam("id") int id ,
                                     @RequestBody ProductRequest productRequest){

        try{

            return new ResponseEntity(productService.addProduct(id,productRequest), HttpStatus.OK);

        }catch (SellerDoNotExist e){

            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public  ResponseEntity getAllProduct(){

        return new ResponseEntity(productService.getAllProduct(),HttpStatus.OK);
    }

    @PutMapping("/id/{id}/price/{price}")
    public ResponseEntity updateProduct(@PathVariable("id") int id ,
                                        @PathVariable("price") int price
    ) {

        try{

            return new ResponseEntity(productService.updateProduct(id,price),HttpStatus.OK);

        }catch(ProductDoNotExist e){

            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") int  id){

        try{

            return new ResponseEntity(productService.deleteProduct(id),HttpStatus.OK);

        }catch (ProductDoNotExist e){

            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);

        }
    }
}
