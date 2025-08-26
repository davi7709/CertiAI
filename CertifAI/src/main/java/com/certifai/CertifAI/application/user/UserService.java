package com.certifai.CertifAI.application.user;

import com.certifai.CertifAI.domain.user.model.User;
import com.certifai.CertifAI.domain.user.repository.UserRepository;
import com.certifai.CertifAI.exception.EmailAlreadyExistsException;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User insertUser(User user) {
        if (userRepository.findByEmail(user.getEmail())){
            throw new EmailAlreadyExistsException("User already exists");
        }
        return userRepository.save(user);
    }

}
