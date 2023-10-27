package com.example.demo.Jwa.Bank.System.Entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "tbl_User")
public class User {     // Class representing a User entity.(The parent class)
    @Id
    private int idUser;  // Unique user ID (primary key)

    private String name; // User's name
    private String email; // User's email address
    private  String password; // User's password
    private  String address;  // User's address

    // This class represents a base user entity that can be extended to create more specific user types.
    // The @Inheritance annotation specifies the inheritance strategy, which is "TABLE_PER_CLASS."

    // No-argument and all-argument constructors are provided for creating User instances.


}


