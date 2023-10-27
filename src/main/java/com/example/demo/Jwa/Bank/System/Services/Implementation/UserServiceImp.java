package com.example.demo.Jwa.Bank.System.Services.Implementation;

import com.example.demo.Jwa.Bank.System.Entity.User;
import com.example.demo.Jwa.Bank.System.Repository.UserRepository;
import com.example.demo.Jwa.Bank.System.Services.Interface.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//
//@Service
//public class UserServiceImp implements UserInterface {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public List<User> getAllUser() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public User getUserById(int idUser) {
//        return userRepository.findById(idUser).orElse(null);
//    }
//
//    @Override
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
//
//    @Override
//    public User updateUser(int idUser, User user) {
//        if (userRepository.existsById(idUser)) {
//            user.setIdUser(idUser); // Ensure the ID is set for the update
//            return userRepository.save(user);
//        }
//        return null; // User with the given ID doesn't exist
//    }
//
//    @Override
//    public void deleteUser(int idUser) {
//        userRepository.deleteById(idUser);
//    }
//}