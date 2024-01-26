package com.example.ris.services;

import com.example.ris.models.entities.Radnik;
import com.example.ris.models.entities.User;
import com.example.ris.repositories.RadnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ris.repositories.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository _UserRepository;

    @Autowired
    private RadnikRepository _RadnikRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = _UserRepository.findByEmail(username);
        final Radnik radnik = _RadnikRepository.findByEmail(username);
        if (user == null) {
            UserDetails newRadnik;
            if(radnik.getRoleId() == 0) {
                newRadnik = org.springframework.security.core.userdetails.User.withUsername(radnik.getEmail()).password(radnik.getPassword()).authorities("SUPERADMIN").build();
                return newRadnik;
            }
            else if(radnik.getRoleId() == 1) {
                newRadnik = org.springframework.security.core.userdetails.User.withUsername(radnik.getEmail()).password(radnik.getPassword()).authorities("ADMIN").build();
                return newRadnik;
            }
            else if(radnik.getRoleId() == 2){
                newRadnik = org.springframework.security.core.userdetails.User.withUsername(radnik.getEmail()).password(radnik.getPassword()).authorities("DOSTAVLJAC").build();
                return newRadnik;
            }
        }
        else if(radnik == null) {
            UserDetails newUser = null;
            if(user.getRoleId() == 3) newUser = org.springframework.security.core.userdetails.User.withUsername(user.getEmail()).password(user.getPassword()).authorities("USER").build();
            return newUser;
        }
       else{
            throw new UsernameNotFoundException(username);
        }

        return null;
    }

}
