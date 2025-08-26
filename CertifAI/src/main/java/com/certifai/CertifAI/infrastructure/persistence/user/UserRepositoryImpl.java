package com.certifai.CertifAI.infrastructure.persistence.user;

import com.certifai.CertifAI.domain.user.model.User;
import com.certifai.CertifAI.domain.user.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

     private final SpringDataUserRepository springDataUserRepository;

     public UserRepositoryImpl(SpringDataUserRepository springDataUserRepository){
         this.springDataUserRepository = springDataUserRepository;
     }

     @Override
     public Optional<User> findByEmail(String email){
         return springDataUserRepository.findByEmail(email);
     }

     @Override
     public User save(User user){
         return springDataUserRepository.save(user);
     }
     @Override
     public List<User> userList(){
         return springDataUserRepository.findAll();
     }

     @Override
    public Optional<User> findById(Long id){
         return springDataUserRepository.findById(id);
     }

     public void delete(Long id){
         springDataUserRepository.deleteById(id);
     }

}
