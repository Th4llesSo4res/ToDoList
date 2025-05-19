package com.todolist.backend.service;

import com.todolist.backend.entity.User;
import com.todolist.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o e-mail: " + email));
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword); // substituir por encoder se desejar
    }
}
