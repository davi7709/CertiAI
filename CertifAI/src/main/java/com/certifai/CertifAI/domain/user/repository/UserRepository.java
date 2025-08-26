package com.certifai.CertifAI.domain.user.repository;

import com.certifai.CertifAI.domain.user.model.User;

public interface UserRepository {
    boolean findByEmail(String email);
    User save(User user);
}
