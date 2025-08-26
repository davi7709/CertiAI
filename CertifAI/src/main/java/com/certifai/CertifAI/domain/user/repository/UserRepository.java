package com.certifai.CertifAI.domain.user.repository;

import com.certifai.CertifAI.domain.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    User save(User user);
    List<User> userList();
    Optional<User> findById(Long id);
    void delete(Long id);
}
