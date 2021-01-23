package com.accolite.restapi_au.repository;

import com.accolite.restapi_au.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<UserData, Integer> {
    public List<UserData> findUserByEmailId(String s);
}
