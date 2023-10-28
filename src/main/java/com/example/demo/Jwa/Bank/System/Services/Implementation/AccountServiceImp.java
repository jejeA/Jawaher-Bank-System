//package com.example.demo.Jwa.Bank.System.Services.Implementation;
//
//import com.example.demo.Jwa.Bank.System.Entity.Account;
//import com.example.demo.Jwa.Bank.System.Repository.AccountRepository;
//import com.example.demo.Jwa.Bank.System.Services.Interface.AccountInterface;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class AccountServiceImp implements AccountInterface {
//    @Autowired
//    private AccountRepository accountRepository;
//    @Autowired
//    private AccountServiceImp accountServiceImp;
//
//
//    @Override
//    public String deposit(int accountNumber, double amount) {
//        Account account = accountRepository.findById(accountNumber).orElse(null);
//        if (account != null && amount > 0) {
//            double balance = account.getBalance();
//            account.setBalance(balance + amount);
//            accountRepository.save(account);
//            return "Successful deposit " + "\n The new balance = " + account.getBalance();
//        }
//        return " Account not found, insufficient balance, or invalid deposit amount";
//    }
//
//    @Override
//    public String withdraw(int accountNumber, double amount) {
//        Account account = accountRepository.findById(accountNumber).orElse(null);
//        if (account != null && amount > 0 && amount <= account.getBalance()) {
//            double balance = account.getBalance();
//            account.setBalance(balance - amount);
//            accountRepository.save(account);
//            return "Successful Withdraw" + "\n The new Balance =" + account.getBalance();
//        }
//        return " Account not found, insufficient balance, or invalid withdraw amount";
//    }
////@Override
////    public String transfer(int sourceAccountNumber, int targetAccountNumber, double amount) {
////        Account sourceAccount = accountRepository.findById(sourceAccountNumber).orElse(null);
////        Account targetAccount = accountRepository.findById(targetAccountNumber).orElse(null);
////
////        if (sourceAccount != null && targetAccount != null && amount > 0 && amount <= sourceAccount.getBalance()) {
////            double sourceBalance = sourceAccount.getBalance();
////            sourceAccount.setBalance(sourceBalance-amount);
////            double targetBalance = targetAccount.getBalance();
////            targetAccount.setBalance(targetBalance+amount);
////
////            accountRepository.save(sourceAccount);
////            accountRepository.save(targetAccount);
////            return "Successful transfer";
////        }
////        return "Account not found, insufficient balance, or invalid transfer amount";
////    }
//
//    @Override
//    public String transfer(int sourceAccountNumber, int targetAccountNumber, double amount) {
//        Account sourceAccount = accountRepository.findById(sourceAccountNumber).orElse(null);
//        Account targetAccount = accountRepository.findById(targetAccountNumber).orElse(null);
//
//        if (sourceAccount != null && targetAccount != null && amount > 0 && amount <= sourceAccount.getBalance()) {
//            double sourceBalance = sourceAccount.getBalance();
//            double targetBalance = targetAccount.getBalance();
//
//            sourceAccount.setBalance(sourceBalance - amount);
//            targetAccount.setBalance(targetBalance + amount);
//
//            accountRepository.save(sourceAccount);
//            accountRepository.save(targetAccount);
//
//            return "Successful transfer";
//        }
//
//        return "Account not found, insufficient balance, or invalid transfer amount";
//    }
//
//    @Override
//    public String showBalance(int accountNumber) {
//        Account account = accountRepository.findById(accountNumber).orElse(null);
//        if (account != null) {
//            return "The balance is " + account.getBalance();
//
//        }
//        return "The Id is wrong";
//    }
//
//    @Override
//    public Account addAccount(Account account) {
//        return accountRepository.save(account);
//    }
//
//    @Override
//    public List<Account> getAllAccount() {
//        return accountRepository.findAll();
//    }
////    @Override
////    public String updateAccount(int accountNumber, Account updatedAccount) {
////            Account account = accountRepository.findById(accountNumber).orElse(null);
////
////            if (account != null) {
////                // You may want to add validation or additional logic here
////                account.setAccountName(updatedAccount.getAccountName());
////                account.setBalance(updatedAccount.getBalance());
////
////                accountRepository.save(account);
////                return "Account updated successfully"+accountNumber;
////            } else {
////                return "Account not found";
////            }
////        }
////
////    }
//
//}


package com.example.demo.Jwa.Bank.System.Services.Implementation;

import com.example.demo.Jwa.Bank.System.Entity.Account;
import com.example.demo.Jwa.Bank.System.Repository.AccountRepository;
import com.example.demo.Jwa.Bank.System.Services.Interface.AccountInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImp implements AccountInterface{
    @Autowired
    private AccountRepository accountRepository;



    // Deposit money into an account
    @Override
    public String deposit(int accountNumber, double amount) {
        Account account = accountRepository.findById(accountNumber).orElse(null);
     //check if account not null and amount bigger than 0 then apply statement inside if
        if (account != null && amount > 0) {
            double balance = account.getBalance();
            //put the new balance in account
            account.setBalance(balance+amount);
          //save the new balance in repository
            accountRepository.save(account);
          //return the statement and the new balance
            return "Successful deposit "+"\n The new balance = " + account.getBalance();
        } // if the statement inside if condition not applied then go to else and print this
        return " Account not found, insufficient balance, or invalid deposit amount";
    }

    // Withdraw money from an account
    @Override
    public String  withdraw(int accountNumber, double amount) {
        Account account = accountRepository.findById(accountNumber).orElse(null);
        //check if account not null and amount bigger than 0 then apply statement inside if
        if (account != null && amount > 0 && amount <= account.getBalance()) {
            double balance =account.getBalance();
            //put the new balance in account
            account.setBalance(balance-amount);
            //save the new balance in repository
            accountRepository.save(account);
            //return the statement and the new balance
            return "Successful Withdraw"+ "\n The new Balance ="+account.getBalance();
        }// if the statement inside if condition not applied then go to else and print this
        return  " Account not found, insufficient balance, or invalid withdraw amount";
    }

    // Transfer money between two accounts
    @Override
    public String transfer(int sourceAccountNumber, int targetAccountNumber, double amount) {
        // Business logic for transferring money between accounts
        Account sourceAccount = accountRepository.findById(sourceAccountNumber).orElse(null);
        Account targetAccount = accountRepository.findById(targetAccountNumber).orElse(null);
        //check if first account  and secont account not null and amount bigger than 0 then apply statement inside if
        if (sourceAccount != null && targetAccount != null && amount > 0 && amount <= sourceAccount.getBalance()) {
            double sourceBalance = sourceAccount.getBalance();
            sourceAccount.setBalance(sourceBalance - amount);
            // transfer from one account to another
            double targetBalance = targetAccount.getBalance();
            targetAccount.setBalance(targetBalance + amount);
            // save the account balance in repository
            accountRepository.save(sourceAccount);
            accountRepository.save(targetAccount);
            //return seccessful transfer
            return "Successful transfer";
        }   // if the statement inside if condition not applied then go to else and print this
        return "Account not found, insufficient balance, or invalid transfer amount";
    }

    // Get the account balance
    @Override
    public String showBalance(int accountNumber) {
        //search about the account by id
        Account account = accountRepository.findById(accountNumber).orElse(null);
        // check if not null
        if (account != null) {
            //return the statement when the account found and have a balance
            return "The balance is " +account.getBalance();
        }
        return "The Id is wrong";
    }


    // Add a new account
    @Override
    public Account addAccount(Account account) {
        //save the new account in the repository
        return accountRepository.save(account);
    }


    // Get a list of all accounts
    @Override
    public List<Account> getAllAccount() {
        //return the all account using method findAll
        return accountRepository.findAll();
    }


    // Delete accounts by balance
    @Override
    public String deleteAccountByBalance(double balance) {
        //delete the account by balance
        accountRepository.deleteByBalance(balance);
        return "Account has been successfully deleted.";
    }


    // Update an existing account
    @Override
    public String updateAccount(int accountNumber, Account account) {
        //check if account exists or no
            if (accountRepository.existsById(accountNumber)) {
                // if exists the account then updated
                account.setAccountNumber(accountNumber);
                //save in the repository
                accountRepository.save(account);
             //  return "account updated Successfully" when the successfully
                return "account updated Successfully";
                //  return "account not updated Successfully"
            }return "account not updated Successfully";

        }
    }
