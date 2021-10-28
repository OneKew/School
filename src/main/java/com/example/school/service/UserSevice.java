package com.example.school.service;

import com.example.school.actions.UserAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSevice implements UserDetailsService {
    @Autowired
    private UserAction userAction;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAction.findByUsername(username);
    }
}