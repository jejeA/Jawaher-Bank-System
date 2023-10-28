package com.example.demo.Jwa.Bank.System.Controller;

import com.example.demo.Jwa.Bank.System.Entity.Account;
import com.example.demo.Jwa.Bank.System.Services.Implementation.AccountServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.*;

@RestController
public class  AccountController {
// Class Controller for handling with HTTP request
    @Autowired
    private AccountServiceImp accountServiceImp;
// Create object for service class


    //requset method for get All account
//    @GetMapping("/accounts")
//    public List<Account> getAllAccount() {
//    try{
//        return accountServiceImp.getAllAccount();
//    }catch (Exception e){
//        return
//    }
    @GetMapping("/accounts")
    public ResponseEntity<?> getAllAccount() {
        try {
            List<Account> accounts = accountServiceImp.getAllAccount();
            return ResponseEntity.ok(accounts);
        } catch (Exception e) {
            // Log the exception for debugging and monitoring
            e.printStackTrace();
            // Return an error response with a custom error message and a 500 (Internal Server Error) status code
            String errorMessage = "An error occurred while fetching accounts.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
    // Endpoint to add a new account
    @PostMapping("/add/account")
    public ResponseEntity<String> addAccount(@RequestBody Account account) {
        try {
            // Call the service to add the account
            accountServiceImp.addAccount(account);
            String message = "Account added successfully";
            // Return a success response
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        }
        catch (Exception e) {
            // Handle exceptions and return an error respons
            String errormessage="Account not added successfully";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errormessage);

        }
    }

    // Endpoint to deposit money into an accoun
    @PostMapping("/deposit/{accountNumber}")
    public ResponseEntity<String> deposit(@PathVariable int accountNumber, @RequestParam double amount) {
        try {
            // Call the service to deposit money
            String message = accountServiceImp.deposit(accountNumber, amount);
            // Return a success response
            return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (Exception e) {
            // Handle exceptions and return an error response
            String errormessage = "deposit not added seccessfully";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errormessage);
        }
    }
    // Endpoint to withdraw money from an account
    @PostMapping("/withdraw/{accountNumber}")
    public ResponseEntity<String> withdraw(@PathVariable int accountNumber, @RequestParam double amount) {
        try {
            // Call the service to withdraw money
            String response = accountServiceImp.withdraw(accountNumber, amount);
            // Return a success response
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            // Handle exceptions and return an error response
            String errormessage = "deposit not added seccessfully";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errormessage);
        }

    }
    // Endpoint to transfer money between accounts
    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(
            @RequestBody int sourceAccountNumber,
            @RequestBody int targetAccountNumber,
            @RequestBody double amount) {
        // Call the service to transfer money
        String message = accountServiceImp.transfer(sourceAccountNumber, targetAccountNumber, amount);
        if ("Successful transfer".equals(message)) {
            // Return a success response
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } else {
            // Return an error response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }


    // Endpoint to get the balance of an account
         @GetMapping("/balance/{accountNumber}")
        public ResponseEntity<String> showBalance(@PathVariable int accountNumber) {
             try {
                 // Call the service to retrieve the balance
                 String response = accountServiceImp.showBalance(accountNumber);
                 // Return a success response
                 return ResponseEntity.status(HttpStatus.OK).body(response);
             } catch (Exception e) {
                 // Handle exceptions and return an error response
                 String errorMessage = "Failed to retrieve balance for account number: " + accountNumber;
                 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
             }
         }
    // Endpoint to delete an account by balance
    @DeleteMapping("/deleteaccount/{balance}")
    public ResponseEntity<String> deleteAccount(@PathVariable double balance) {
        try {
            // Call the service to delete an account by balance
            String message = accountServiceImp.deleteAccountByBalance(balance);
            // Return a success response
            return ResponseEntity.ok(message); // use ResponseEntity.ok for HTTP 200
        } catch (Exception e) {
            // Handle exceptions and return an error response
            String errorMessage = "Account not deleted successfully";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }

    }

    // Endpoint to update an account
    @PutMapping("/updateAccount/{accountNumber}")
    public ResponseEntity<String> updateAccount(@PathVariable int accountNumber, @RequestBody Account account) throws AccountNotFoundException {
        // Call the service to update an account
        String updatedAccount= accountServiceImp.updateAccount(accountNumber, account);

        if (updatedAccount != null) {
            // Return a success response
            String message = "Account updated successfully";
            return ResponseEntity.ok(message);
        } else {
            // Throw an exception if the account is not found
            throw new AccountNotFoundException("Account with the given ID not found");
        }
    }
}

