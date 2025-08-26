package com.certifai.CertifAI.infrastructure.persistence.user;

import com.certifai.CertifAI.domain.user.model.User;
import com.certifai.CertifAI.domain.user.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

     private final SpringDataUserRepository springDataUserRepository;

     public UserRepositoryImpl(SpringDataUserRepository springDataUserRepository){
         this.springDataUserRepository = springDataUserRepository;
     }

     @Override
     public boolean findByEmail(String email){
         return springDataUserRepository.findByEmail(email);
     }

     @Override
     public User save(User user){
         return springDataUserRepository.save(user);
     }
}
