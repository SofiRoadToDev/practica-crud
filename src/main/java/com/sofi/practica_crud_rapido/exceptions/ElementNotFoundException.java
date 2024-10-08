package com.sofi.practica_crud_rapido.exceptions;

public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException(String message) {
        super(message);
    }
}
