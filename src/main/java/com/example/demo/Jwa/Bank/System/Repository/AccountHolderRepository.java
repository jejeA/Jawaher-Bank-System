package com.example.demo.Jwa.Bank.System.Repository;

import com.example.demo.Jwa.Bank.System.Entity.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository  extends JpaRepository<AccountHolder,Integer > {
}
//The repository of  AccountHolder class  you can use it for write query to the database and write j unit Test
