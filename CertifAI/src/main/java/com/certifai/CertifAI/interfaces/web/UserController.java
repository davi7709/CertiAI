package com.certifai.CertifAI.interfaces.web;

import com.certifai.CertifAI.application.user.UserService;
import com.certifai.CertifAI.domain.user.model.User;
import com.certifai.CertifAI.exception.EmailAlreadyExistsException;
import com.certifai.CertifAI.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

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

    @GetMapping("/listAll")
    public ResponseEntity<List<User>> getAllUsers(){
        try{
            List<User> users = userService.allUsers();
            return ResponseEntity.status(HttpStatus.CREATED).body(users);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                            .body(Collections.emptyList());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        try{
            User user = userService.getUserById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(user);
        }catch(UserNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        try{
            userService.deleteUserById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User deleted successfully");
        }catch(UserNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user");
        }
    }


}
