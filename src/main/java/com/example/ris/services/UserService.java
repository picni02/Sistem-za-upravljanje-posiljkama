package com.example.ris.services;

import java.util.List;

import com.example.ris.models.entities.Dostavljac;
import com.example.ris.models.entities.User;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserByEmail(String username);
    public User getUserByID(String idUser);
    public List<User> getUsersByRole(int roleID);
    public User registerUser(User user);
    public void deleteUser(String userEmail);
}
