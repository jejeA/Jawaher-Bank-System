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



    @Override
    public String deposit(int accountNumber, double amount) {
        Account account = accountRepository.findById(accountNumber).orElse(null);
        if (account != null && amount > 0) {
            double balance = account.getBalance();
            account.setBalance(balance+amount);
            accountRepository.save(account);
            return "Successful deposit "+"\n The new balance = " + account.getBalance();
        }
        return " Account not found, insufficient balance, or invalid deposit amount";
    }
    @Override
    public String  withdraw(int accountNumber, double amount) {
        Account account = accountRepository.findById(accountNumber).orElse(null);
        if (account != null && amount > 0 && amount <= account.getBalance()) {
            double balance =account.getBalance();
            account.setBalance(balance-amount);
            accountRepository.save(account);
            return "Successful Withdraw"+ "\n The new Balance ="+account.getBalance();
        }
        return  " Account not found, insufficient balance, or invalid withdraw amount";
    }
    @Override
    public String transfer(int sourceAccountNumber, int targetAccountNumber, double amount) {
        // Business logic for transferring money between accounts
        Account sourceAccount = accountRepository.findById(sourceAccountNumber).orElse(null);
        Account targetAccount = accountRepository.findById(targetAccountNumber).orElse(null);

        if (sourceAccount != null && targetAccount != null && amount > 0 && amount <= sourceAccount.getBalance()) {
            double sourceBalance = sourceAccount.getBalance();
            sourceAccount.setBalance(sourceBalance - amount);
            double targetBalance = targetAccount.getBalance();
            targetAccount.setBalance(targetBalance + amount);

            accountRepository.save(sourceAccount);
            accountRepository.save(targetAccount);
            return "Successful transfer";
        }
        return "Account not found, insufficient balance, or invalid transfer amount";
    }

    @Override
    public String showBalance(int accountNumber) {
        Account account = accountRepository.findById(accountNumber).orElse(null);
        if (account != null) {
            return "The balance is " +account.getBalance();

        }
        return "The Id is wrong";
    }

    @Override
    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }




    @Override
    public String deleteAccountByBalance(double balance) {
        accountRepository.deleteByBalance(balance);
        return "Account has been successfully deleted.";
    }

@Override
    public String updateAccount(int accountNumber, Account account) {
            if (accountRepository.existsById(accountNumber)) {
                account.setAccountNumber(accountNumber); // Ensure the ID is set for the update
                accountRepository.save(account);
                return "account updated Successfully";

            }
            return "account not updated Successfully";

        }
    }
