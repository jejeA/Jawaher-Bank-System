package com.example.demo.Jwa.Bank.System.Controller;

import com.example.demo.Jwa.Bank.System.Entity.Account;
import com.example.demo.Jwa.Bank.System.Entity.AccountHolder;
import com.example.demo.Jwa.Bank.System.Entity.AccountHolderNotFoundException;
import com.example.demo.Jwa.Bank.System.Services.Implementation.AccountServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.*;

@RestController
public class  AccountController {

    @Autowired
    private AccountServiceImp accountServiceImp;


    @GetMapping("/accounts")
    public List<Account> getAllAccount() {
        return accountServiceImp.getAllAccount();
    }


    @PostMapping("/add/account")
    public ResponseEntity<String> addAccount(@RequestBody Account account) {
        try {

            accountServiceImp.addAccount(account);
            String message = "Account added successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        }
        catch (Exception e) {
            String errormessage="Account not added successfully";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errormessage);

        }
    }


    @PostMapping("/deposit/{accountNumber}")
    public ResponseEntity<String> deposit(@PathVariable int accountNumber, @RequestParam double amount) {
        try {
            String message = accountServiceImp.deposit(accountNumber, amount);
            return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (Exception e) {
            String errormessage = "deposit not added seccessfully";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errormessage);
        }
    }

    @PostMapping("/withdraw/{accountNumber}")
    public ResponseEntity<String> withdraw(@PathVariable int accountNumber, @RequestParam double amount) {
        try {
            String response = accountServiceImp.withdraw(accountNumber, amount);
            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            String errormessage = "deposit not added seccessfully";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errormessage);
        }

    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(
            @RequestBody int sourceAccountNumber,
            @RequestBody int targetAccountNumber,
            @RequestBody double amount) {

        String message = accountServiceImp.transfer(sourceAccountNumber, targetAccountNumber, amount);

        if ("Successful transfer".equals(message)) {
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }


         @GetMapping("/balance/{accountNumber}")
        public ResponseEntity<String> showBalance(@PathVariable int accountNumber) {
             try {
                 String response = accountServiceImp.showBalance(accountNumber);
                 return ResponseEntity.status(HttpStatus.OK).body(response);
             } catch (Exception e) {
                 String errorMessage = "Failed to retrieve balance for account number: " + accountNumber;
                 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
             }
         }

    @DeleteMapping("/deleteaccount/{balance}")
    public ResponseEntity<String> deleteAccount(@PathVariable double balance) {
        try {
            String message = accountServiceImp.deleteAccountByBalance(balance);
            return ResponseEntity.ok(message); // You can use ResponseEntity.ok for HTTP 200
        } catch (Exception e) {
            String errorMessage = "Account not deleted successfully";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }

    }
    @PutMapping("/updateAccount/{accountNumber}")
    public ResponseEntity<String> updateAccount(@PathVariable int accountNumber, @RequestBody Account account) throws AccountNotFoundException {
        String updatedAccount= accountServiceImp.updateAccount(accountNumber, account);

        if (updatedAccount != null) {
            String message = "Account updated successfully";
            return ResponseEntity.ok(message);
        } else {
            throw new AccountNotFoundException("Account with the given ID not found");
        }
    }
}

