package com.example.demo.Jwa.Bank.System.Entity;

public class AccountHolderNotFoundException extends RuntimeException {
    // Custom exception class for handling Account Holder not found exceptions.
    public AccountHolderNotFoundException(String message) {
        super(message); // Constructor that takes a custom error message.
    }
}
