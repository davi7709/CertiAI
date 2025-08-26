package com.certifai.CertifAI.infrastructure.persistence.user;

import com.certifai.CertifAI.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserRepository extends JpaRepository<User, Long> {
    boolean findByEmail(String email);
}
