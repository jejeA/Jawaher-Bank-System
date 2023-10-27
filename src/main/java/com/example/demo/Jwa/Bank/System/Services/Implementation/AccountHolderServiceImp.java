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




    @Override
    public AccountHolder createAccountHolder(AccountHolder accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }

    @Override
    public String updateAccountHolder(int id, AccountHolder accountHolder) {
        if (accountHolderRepository.existsById(id)) {
            accountHolder.setIdUser(id); // Ensure the ID is set for the update
            accountHolderRepository.save(accountHolder);
            return "account updated Successfully";

        }
        return "account not updated Successfully";

    }

    @Override
    public String deleteAccountHolder(int id) {
        accountHolderRepository.deleteById(id);
        return "account deleted Successfully";
//        }else return "account not found";
    }


    public List<AccountHolder> getAllAccountHolders() {
        return accountHolderRepository.findAll();
    }

    @Override
    public Optional<AccountHolder> findByAccountHoldertId(int id) {
        return accountHolderRepository.findById(id);
    }

    public String partialUpdate(int id, String name) {
        Optional<AccountHolder> existingAccountHolder = accountHolderRepository.findById(id);

        if (existingAccountHolder.isPresent()) {
            AccountHolder accountHolder = existingAccountHolder.get();

            // Update the first name if the new first name is not null
            if (name != null) {
                accountHolder.setName(name);
            }
            // Save the updated account holder
            accountHolderRepository.save(accountHolder);

            return "Account holder name updated successfully";
        } else {
            throw new EntityNotFoundException("Account holder not found");
        }
    }
}
