package com.example.ris.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import com.example.ris.models.entities.Dostavljac;
import com.example.ris.models.entities.User;
import com.example.ris.repositories.UserRepository;
import com.example.ris.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository _UserRepository;

    @Autowired
    private PasswordEncoder _PasswordEncoder;

    @Override
    public List<User> getAllUsers() {
        List<User> users = _UserRepository.findAll();
        return users.stream().map(User::new).collect(Collectors.toList());
    }

    public User getUserByEmail(String username) {
        return _UserRepository.findByEmail(username);
    }

    @Override
    public User getUserByID(String idUser) {
        return _UserRepository.getUserByID(idUser);
    }

    @Override
    public List<User> getUsersByRole(int roleID) {
       List<User> users = _UserRepository.getUsersByRole(roleID);
        return users.stream().map(User::new).collect(Collectors.toList());
    }

    @Override
    public User registerUser(User userIn) {
        List<User> users = this.getAllUsers();
        User temp;
        try {
            temp = new User(userIn);
            for(User user : users) if(user.getEmail().equals(temp.getEmail())) throw new Exception("User postoji");
            temp.setPassword(_PasswordEncoder.encode(temp.getPassword()));
            temp.setRoleId(3);
            _UserRepository.save(temp);
            return new User(temp);
        } catch (Exception e) {}
        return null;
    }

    @Override
    public void deleteUser(String userEmail) {
        User user = _UserRepository.findByEmail(userEmail);
        _UserRepository.delete(user);
    }
}
