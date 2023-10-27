package com.example.demo.Jwa.Bank.System.Services.Interface;

//import com.example.demo.Jwa.Bank.System.Entity.Account;
//
//import java.util.List;
//
//public interface AccountInterface {
//
//
//    String deposit(int accountNumber, double amount);
//    String withdraw(int accountNumber, double amount);
//    String transfer(int sourceAccountNumber, int targetAccountNumber, double amount);
//    String showBalance(int accountNumber);
//
//    Account addAccount(Account account);
//
//    List<Account> getAllAccount();
//
//
////    String deleteAccount(int accountNumber);
//}
import com.example.demo.Jwa.Bank.System.Entity.Account;

import java.util.List;

public interface AccountInterface {
    // Interface for managing Account entities.

    String deposit(int accountNumber, double amount);
    // Deposit money into an account and return a status message.

    String withdraw(int accountNumber, double amount);
    // Withdraw money from an account and return a status message.

    String transfer(int sourceAccountNumber, int targetAccountNumber, double amount);
    // Transfer money between two accounts and return a status message.

    String showBalance(int accountNumber);
    // Retrieve the balance of an account and return a status message.

    Account addAccount(Account account);
    // Add a new account and return the created account.

    List<Account> getAllAccount();
    // Retrieve a list of all accounts.

    String deleteAccountByBalance(double balance);
    // delete account by balance and return the deleted account.

    String updateAccount(int accountNumber, Account account);
    // Update an existing Account by accountNumber.



}
