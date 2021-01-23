package com.accolite.restapi_au.service.impl;

import com.accolite.restapi_au.entity.UserData;
import com.accolite.restapi_au.repository.UserRepo;
import com.accolite.restapi_au.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Bean
    @Primary
    public BCryptPasswordEncoder getpce()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserData addUser(UserData user){
        String plainPassword = user.getPassword();
        String encryptedPassword = getEncryptedPassword(plainPassword);
        user.setPassword(encryptedPassword);

        UserData savedUser = userRepo.save(user);
        return savedUser;
    }

    @Override
    public UserData getUserById(Integer id){
        Optional<UserData> user = userRepo.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public UserData updateUser(UserData user) {
        String plainPassword = user.getPassword();
        String encryptedPassword = getEncryptedPassword(plainPassword);
        user.setPassword(encryptedPassword);
        user = userRepo.save(user);
        return user;
    }

    @Override
    public String deleteUser(Integer id){
        userRepo.deleteById(id);
        return "Delete Success";
    }


    private String getEncryptedPassword(String plainPassword) {
        return getpce().encode(plainPassword);
    }
}
