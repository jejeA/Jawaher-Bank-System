package com.example.demo.Jwa.Bank.System.Entity;

// import package
import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

@Table(name = "tbl_AccountHolder")
public class AccountHolder extends User{
// Class representing an Account Holder entity.

    @OneToOne
    private Account account;   // One-to-one relationship with Account entity

    //constructor
    public AccountHolder(int idUser, String name, String email, String password, String address,Account account) {
        super(idUser, name, email, password, address);
        setAccount(account);
    }

}


