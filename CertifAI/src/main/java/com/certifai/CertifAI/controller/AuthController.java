package com.certifai.CertifAI.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return "Login realizado com sucesso!";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Isso renderiza o login.html de /templates
    }
}
