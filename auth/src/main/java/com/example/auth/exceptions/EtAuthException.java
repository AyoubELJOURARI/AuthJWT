package com.example.auth.exceptions;

public class EtAuthException extends RuntimeException{
    public static final long serialVersionUID = 1l;



    public EtAuthException(String message) {
        super(message);
    }
}
