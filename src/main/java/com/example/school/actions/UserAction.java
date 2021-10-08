package com.example.school.actions;

import com.example.school.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserAction extends CrudRepository<User, Long> {

    List<User> findByEmail(String email);
}
