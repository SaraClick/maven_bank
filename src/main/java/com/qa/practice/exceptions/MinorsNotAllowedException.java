package com.qa.practice.exceptions;

public class MinorsNotAllowedException extends RuntimeException{
    public MinorsNotAllowedException(String message) {
        super(message);
    }
}
