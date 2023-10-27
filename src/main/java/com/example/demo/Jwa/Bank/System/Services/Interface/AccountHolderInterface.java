package com.example.demo.Jwa.Bank.System.Services.Interface;

//import com.example.demo.Jwa.Bank.System.Entity.AccountHolder;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface AccountHolderInterface {
//
//
//    AccountHolder createAccountHolder(AccountHolder accountHolder);
//    String updateAccountHolder(int id, AccountHolder accountHolder);
//    String deleteAccountHolder(int id);
//   List<AccountHolder> getAllAccountHolders();
//    Optional<AccountHolder> findByAccountHoldertId(int id);
//}
import com.example.demo.Jwa.Bank.System.Entity.AccountHolder;

import java.util.List;
import java.util.Optional;

public interface AccountHolderInterface {
    // Interface for managing AccountHolder entities.

    AccountHolder createAccountHolder(AccountHolder accountHolder);
    // Create a new AccountHolder.

    String updateAccountHolder(int id, AccountHolder accountHolder);
    // Update an existing AccountHolder by ID.

    String deleteAccountHolder(int id);
    // Delete an AccountHolder by ID.

    List<AccountHolder> getAllAccountHolders();
    // Retrieve a list of all AccountHolders.

    Optional<AccountHolder> findByAccountHoldertId(int id);
    // Find an AccountHolder by their ID and return it as an Optional.

    public String partialUpdate(int id, String name);
}
