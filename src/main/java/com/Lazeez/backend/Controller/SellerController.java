package com.Lazeez.backend.Controller;

import com.Lazeez.backend.DTO.Request.SellerRequest;
import com.Lazeez.backend.DTO.Response.SellerResponse;
import com.Lazeez.backend.Exception.SellerAlreadyExist;
import com.Lazeez.backend.Exception.SellerDoNotExist;
import com.Lazeez.backend.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping
    public ResponseEntity addSeller(@RequestBody SellerRequest sellerRequest){

        try{
            SellerResponse sellerResponse=sellerService.addSeller(sellerRequest);
            return new ResponseEntity(sellerResponse, HttpStatus.OK);
        }catch (SellerAlreadyExist e){
            return  new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity getSeller(@PathVariable int id){

        try{

            SellerResponse sellerResponse= sellerService.getSeller(id);
            return new ResponseEntity(sellerResponse,HttpStatus.OK);
        }catch (SellerDoNotExist e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    public ResponseEntity getAllSeller(){
        try{
            List<SellerResponse> sellerResponses=sellerService.getAllSeller();
            return new ResponseEntity(sellerResponses,HttpStatus.OK);

        }catch (SellerDoNotExist e){

            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSeller(@PathVariable("id") int id){

        try{

            return new ResponseEntity(sellerService.deleteSeller(id),HttpStatus.OK);

        }catch (SellerDoNotExist e){

            return new ResponseEntity(e.getMessage(),HttpStatus.OK);
        }

    }

}
