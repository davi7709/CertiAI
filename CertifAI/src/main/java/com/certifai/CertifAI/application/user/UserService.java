package com.certifai.CertifAI.application.user;

import com.certifai.CertifAI.domain.user.model.User;
import com.certifai.CertifAI.domain.user.repository.UserRepository;
import com.certifai.CertifAI.exception.EmailAlreadyExistsException;
import com.certifai.CertifAI.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User insertUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException("User already exists");
        }
        return userRepository.save(user);
    }

    public List<User> allUsers(){
        return userRepository.userList();
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() ->new UserNotFoundException(id));
    }

    public void deleteUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }


}
