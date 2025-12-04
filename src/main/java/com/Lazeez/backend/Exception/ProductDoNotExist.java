package com.Lazeez.backend.Exception;

public class ProductDoNotExist extends RuntimeException{

 public  ProductDoNotExist(String msg){
        super(msg);
    }
}
