package com.example.demo.Jwa.Bank.System.Repository;

import com.example.demo.Jwa.Bank.System.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account ,Integer> {
    String deleteByBalance(double balance);
}
//The repository of  Account class  you can use it for write query to the database and write j unit Test