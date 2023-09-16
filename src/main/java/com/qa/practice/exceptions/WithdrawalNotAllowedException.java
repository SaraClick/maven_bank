package com.qa.practice.exceptions;

public class WithdrawalNotAllowedException extends RuntimeException{
    public WithdrawalNotAllowedException(String message) {
        super(message);
    }
}
