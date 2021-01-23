package com.accolite.restapi_au.service;

import com.accolite.restapi_au.entity.UserData;

public interface UserService {

    public UserData addUser(UserData user);

    public UserData getUserById(Integer id);

    public UserData updateUser(UserData user);

    public String deleteUser(Integer id);

}
