package com.todolist.backend.controller;

import com.todolist.backend.entity.User;
import com.todolist.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            return "E-mail já cadastrado.";
        }
        userService.saveUser(user);
        return "Usuário cadastrado com sucesso!";
    }

    @PostMapping("/login")
public String login(@RequestBody User user) {
    User existing = userService.findByEmail(user.getEmail());
    if (existing != null && userService.checkPassword(user.getPassword(), existing.getPassword())) {
        return "Login realizado com sucesso!";
    }
    return "Credenciais inválidas.";
}

}
