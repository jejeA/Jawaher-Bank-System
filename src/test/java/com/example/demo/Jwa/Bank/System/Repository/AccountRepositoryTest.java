package com.example.demo.Jwa.Bank.System.Repository;

import com.example.demo.Jwa.Bank.System.Entity.Account;
import com.example.demo.Jwa.Bank.System.Entity.AccountHolder;
import com.example.demo.Jwa.Bank.System.Entity.AccountStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountRepository accountRepository1;
    @Autowired
    private AccountRepository accountRepository2;
    @Autowired
    private AccountRepository accountRepository3;
    @Autowired
    private AccountRepository accountRepository4;

    private Account account;
    private Account account1;
    private Account account2;
    private Account account3;
    private Account account4;
    @Autowired
    private AccountHolderRepository accountHolderRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository1;
    @Autowired
    private AccountHolderRepository accountHolderRepository2;
    @Autowired
    private AccountHolderRepository accountHolderRepository3;
    @Autowired
    private AccountHolderRepository accountHolderRepository4;

    private AccountHolder accountHolder;
    private AccountHolder accountHolder1;
    private AccountHolder accountHolder2;
    private AccountHolder accountHolder3;
    private AccountHolder accountHolder4;

@Test
public void setup(){

    accountHolder=new AccountHolder(1287,"Tahani","tahani@gmail.com","Ta1234","Khobar", null);
    account =new Account("Business",8745,8000.0,AccountStatus.SavingAccount);
    accountHolder.setAccount(account);
    accountRepository.save(account);
    accountHolderRepository.save(accountHolder);


    accountHolder1=new AccountHolder(1324,"Jawaher","ad.jwa@gmail.com","Ad09098","Riyadh", null);
    account1 =new Account("Business",6773,9000.0,AccountStatus.SavingAccount);
    accountHolder1.setAccount(account1);
    accountRepository1.save(account1);
    accountHolderRepository1.save(accountHolder1);


    accountHolder2=new AccountHolder(7893,"Shahad","Shahad@gmail.com","Sh1234","Tabuk", null);
    account2 =new Account("Business",1290,10000.0,AccountStatus.CheckingAccount);
    accountHolder2.setAccount(account2);
    accountRepository2.save(account2);
    accountHolderRepository2.save(accountHolder2);

    accountHolder3=new AccountHolder(6567,"Rahaf","rahaf@gmail.com","Ra1234","Jeddah", null);
    account3 =new Account("Business",8789,15000.0,AccountStatus.CheckingAccount);
    accountHolder3.setAccount(account3);
    accountRepository3.save(account3);
    accountHolderRepository3.save(accountHolder3);

    accountHolder4=new AccountHolder(1009,"Manar","Manar@gmail.com","Ma1234","Abha", null);
    account4 =new Account("Business",7589,6000.0,AccountStatus.SavingAccount);
    accountHolder4.setAccount(account4);
    accountRepository4.save(account4);
    accountHolderRepository4.save(accountHolder4);



}



}