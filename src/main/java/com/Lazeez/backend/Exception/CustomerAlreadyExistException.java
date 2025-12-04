package com.Lazeez.backend.Exception;

public class CustomerAlreadyExistException extends RuntimeException{

    public CustomerAlreadyExistException(String msg){
        super(msg);
    }
}
