//package com.example.demo.Jwa.Bank.System.Controller;
//
//import com.example.demo.Jwa.Bank.System.Entity.AccountHolder;
//import com.example.demo.Jwa.Bank.System.Entity.AccountHolderNotFoundException;
//import com.example.demo.Jwa.Bank.System.Services.Implementation.AccountHolderServiceImp;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//public class AccountHolderController {
//
//    @Autowired
//    private AccountHolderServiceImp accountHolderServiceImp;
//
//
//    @GetMapping("/alltables")
//    public List<AccountHolder> getAllAccountHolders() {
//        return accountHolderServiceImp.getAllAccountHolders();
//    }
//
//    @GetMapping("/Accountholder/{id}")
//    public Optional<AccountHolder> findByAccountHoldertId(@PathVariable int id) {
//        return accountHolderServiceImp.findByAccountHoldertId(id);
//    }
//
//    @PostMapping("/add/accountholder")
//    public ResponseEntity<String> addAccountHolder(@RequestBody  AccountHolder accountHolder) {
//        try {
//            // AccountHolder createdAccountHolder = accountHolderServiceImp.createAccountHolder(accountHolder);
//            accountHolderServiceImp.createAccountHolder(accountHolder);
//            String message = "AcountHolder added seccessfully";
//            return ResponseEntity.status(HttpStatus.CREATED).body(message);
//        }
//     catch (Exception e) {
//                String errormessage="AcountHolder not added seccessfully" + e.getMessage();
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errormessage);
//
//            }
//        }
//
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<String> updateAccountHolder(@PathVariable int id, @RequestBody AccountHolder accountHolder) {
//        String updatedAccountHolder = accountHolderServiceImp.updateAccountHolder(id, accountHolder);
//
//        if (updatedAccountHolder != null) {
//            String message = "Account holder updated successfully";
//            return ResponseEntity.ok(message);
//        } else {
//            throw new AccountHolderNotFoundException("Account holder with the given ID not found");
//        }
//    }
//
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteAccountHolder(@PathVariable int id) {
//       try{
//       String message= accountHolderServiceImp.deleteAccountHolder(id);
//        return ResponseEntity.status(HttpStatus.OK).body(message);
//
//    } catch (Exception e) {
//        String errormessage = "account not deleted seccessfully";
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errormessage);
//    }
//    }
//
//
//
//
//}



package com.example.demo.Jwa.Bank.System.Controller;

import com.example.demo.Jwa.Bank.System.Entity.AccountHolder;
import com.example.demo.Jwa.Bank.System.Entity.AccountHolderNotFoundException;
import com.example.demo.Jwa.Bank.System.Services.Implementation.AccountHolderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountHolderController {
/// Class Controller for handling with HTTP request
    @Autowired
    private AccountHolderServiceImp accountHolderServiceImp;
    // Create object for service class


    // Get all account holders
    @GetMapping("/alltables")
    public List<AccountHolder> getAllAccountHolders() {
        return accountHolderServiceImp.getAllAccountHolders();
    }

    // Get account holder by ID
    @GetMapping("/Accountholder/{id}")
    public Optional<AccountHolder> findByAccountHoldertId(@PathVariable int id) {
        return accountHolderServiceImp.findByAccountHoldertId(id);
    }

    // Add a new account holder
    @PostMapping("/add/accountholder")
    public ResponseEntity<String> addAccountHolder(@RequestBody AccountHolder accountHolder) {
        try {
            // AccountHolder createdAccountHolder = accountHolderServiceImp.createAccountHolder(accountHolder);
            accountHolderServiceImp.createAccountHolder(accountHolder);
            String message = "AcountHolder added seccessfully";
            // Return a success response
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } catch (Exception e) {
            // Handle exceptions and return an error respons
            String errormessage = "AcountHolder not added seccessfully" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errormessage);

        }
    }

    // Update an account holder
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAccountHolder(@PathVariable int id, @RequestBody AccountHolder accountHolder) {
        // Call the service to update an account
        String updatedAccountHolder = accountHolderServiceImp.updateAccountHolder(id, accountHolder);

        if (updatedAccountHolder != null) {
            // Return a success response
            String message = "Account holder updated successfully";
            return ResponseEntity.ok(message);
        } else {
            // Throw an exception if the account is not found
            throw new AccountHolderNotFoundException("Account holder with the given ID not found");
        }
    }


    // Delete an account holder
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccountHolder(@PathVariable int id) {
        try {
            // Call the service to delete an account by balance
            String message = accountHolderServiceImp.deleteAccountHolder(id);
            // Return a success response
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            // Handle exceptions and return an error response
            String errormessage = "account holder not deleted seccessfully";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errormessage);
        }
    }

    // Partially update an account holder
    @PatchMapping("/AccountHolder/updatepatch/{id}")
    public ResponseEntity<String> partialUpdateAccountHolder(@PathVariable int id, @RequestBody String name) {
        try {
            // Call the service to update an account
            String message = accountHolderServiceImp.partialUpdate(id, name);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            // Handle exceptions and return an error response
            String errormessage = "account holder not deleted seccessfully";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errormessage);
        }

    }
}


