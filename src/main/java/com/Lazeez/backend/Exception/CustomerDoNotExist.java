package com.Lazeez.backend.Exception;

public class CustomerDoNotExist extends RuntimeException{

    public CustomerDoNotExist(String msg){
        super(msg);
    }
}
