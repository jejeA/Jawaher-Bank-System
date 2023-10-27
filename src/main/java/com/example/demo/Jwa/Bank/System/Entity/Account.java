package com.example.demo.Jwa.Bank.System.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor

@Table(name = "tbl_Account")
public class Account {           // Class representing a bank account entity.

    private String AccountName;  // Name of the account holder

    @Id
    private int accountNumber;     // Unique account number (primary key)

    private double balance;       // Current balance of the account


    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;   // Status of the account (e.g., Checking account,Saving account etc.)


    // Constructor to initialize the Account entity with provided values.
    public Account(String accountName, int accountNumber, double balance, AccountStatus accountStatus) {
        AccountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountStatus = accountStatus;

    }
}
