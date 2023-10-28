//package com.example.demo.Jwa.Bank.System.Services.Implementation;
//import com.example.demo.Jwa.Bank.System.Entity.AccountHolder;
//import com.example.demo.Jwa.Bank.System.Repository.AccountHolderRepository;
//import com.example.demo.Jwa.Bank.System.Services.Interface.AccountHolderInterface;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.*;
//
//
//@Service
//public class AccountHolderServiceImp implements AccountHolderInterface {
//
//    @Autowired
//    private AccountHolderRepository accountHolderRepository;
//
//    @Override
//    public AccountHolder createAccountHolder(AccountHolder accountHolder) {
//        return accountHolderRepository.save(accountHolder); // Create a new account holder
//    }
//
//    @Override
//    public String updateAccountHolder(int id, AccountHolder accountHolder) {
//        if (accountHolderRepository.existsById(id)) {
//            accountHolder.setIdUser(id); // Ensure the ID is set for the update
//            accountHolderRepository.save(accountHolder); // Update the account holder
//            return "account updated Successfully";
//        }
//        return "account not updated Successfully";
//    }
//
//    @Override
//    public String deleteAccountHolder(int id) {
//        accountHolderRepository.deleteById(id); // Delete the account holder by ID
//        return "account deleted Successfully";
//        // Uncomment the following line if you want to handle the case where the account doesn't exist.
//        // return "account not found";
//    }
//
//    public List<AccountHolder> getAllAccountHolders() {
//        return accountHolderRepository.findAll(); // Retrieve a list of all account holders
//    }
//
//    @Override
//    public Optional<AccountHolder> findByAccountHoldertId(int id) {
//        return accountHolderRepository.findById(id); // Find an account holder by ID
//    }
//}


package com.example.demo.Jwa.Bank.System.Services.Implementation;
import com.example.demo.Jwa.Bank.System.Entity.AccountHolder;
import com.example.demo.Jwa.Bank.System.Repository.AccountHolderRepository;
import com.example.demo.Jwa.Bank.System.Services.Interface.AccountHolderInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountHolderServiceImp implements AccountHolderInterface {

    @Autowired
    private AccountHolderRepository accountHolderRepository;
    //create object from repository


    // Create a new account holder
    @Override
    public AccountHolder createAccountHolder(AccountHolder accountHolder) {
    //save the new account holder in repository
        return accountHolderRepository.save(accountHolder);
    }

    // Update an existing account holder
    @Override
    public String updateAccountHolder(int id, AccountHolder accountHolder) {
        // check if the account exists or no
        if (accountHolderRepository.existsById(id)) {
            accountHolder.setIdUser(id);
            //save the new updated info in the repository
            accountHolderRepository.save(accountHolder);
            //return the statement if "account updated Successfully"
            return "account updated Successfully";
        }  //return the statement if "account not updated Successfully"
        return "account not updated Successfully";

    }

    // Delete an account holder by ID
    @Override
    public String deleteAccountHolder(int id) {
        // search about the account and deleted
        accountHolderRepository.deleteById(id);
        //return the statement if "account deleted Successfully"
        return "account deleted Successfully";
//
    }

    // Retrieve a list of all account holders
    public List<AccountHolder> getAllAccountHolders() {
        //find all Account holder and return
        return accountHolderRepository.findAll();
    }


    // Find an account holder by ID
    @Override
    public Optional<AccountHolder> findByAccountHoldertId(int id) {
        //search about the account holder by Id  and return it
        return accountHolderRepository.findById(id);
    }

    //update the account holder partially
    public String partialUpdate(int id, String name) {
        //search about the account holder
        Optional<AccountHolder> existingAccountHolder = accountHolderRepository.findById(id);
        // if exists and present go inside the if statement
        if (existingAccountHolder.isPresent()) {
            AccountHolder accountHolder = existingAccountHolder.get();
            // Update the  name if the new  name is not null
            if (name != null) {
                accountHolder.setName(name);
            }
            // Save the updated account holder
            accountHolderRepository.save(accountHolder);
           //  return the account holder name updated successfully"
            return "Account holder name updated successfully";
        } else {
            // if no go to throw exception and return Account holder not found
            throw new EntityNotFoundException("Account holder not found");
        }
    }
}
