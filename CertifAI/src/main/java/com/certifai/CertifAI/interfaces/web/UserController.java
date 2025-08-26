package com.certifai.CertifAI.interfaces.web;

import com.certifai.CertifAI.application.user.UserService;
import com.certifai.CertifAI.domain.user.model.User;
import com.certifai.CertifAI.exception.EmailAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody User user){
        try{
            User userCreated = userService.insertUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }catch(EmailAlreadyExistsException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
