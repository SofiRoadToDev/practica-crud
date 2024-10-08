package com.sofi.practica_crud_rapido.exceptions;

public class ElementDuplicatedException extends RuntimeException{
    public ElementDuplicatedException(String message) {
        super(message);
    }
}
