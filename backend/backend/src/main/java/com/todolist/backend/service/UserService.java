package com.todolist.backend.service;

import com.todolist.backend.entity.User;
import com.todolist.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 🔧 Declarando o encoder
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User saveUser(User user) {
        // Criptografa a senha antes de salvar
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        // Verifica se a senha enviada bate com a senha criptografada
        return encoder.matches(rawPassword, encodedPassword);
    }
}
