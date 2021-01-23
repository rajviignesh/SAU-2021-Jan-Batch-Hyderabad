package com.accolite.restapi_au.controllers;


import com.accolite.restapi_au.entity.UserData;
import com.accolite.restapi_au.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signup")
    public UserData signUp(@RequestBody Map<String, String> userDetails){
        System.out.println(userDetails);
        String emailId = userDetails.get("emailId");
        String password = userDetails.get("password");

        UserData user = new UserData();
        user.setEmailId(emailId);
        user.setPassword(password);

        UserData savedUser = userService.addUser(user);


        return savedUser;
    }

    @GetMapping("/get/{id}")
    public UserData getUser(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateUser(@RequestBody UserData updateUser,
                                                       @RequestHeader("password") String passwordLogin){
        UserData user = userService.getUserById(updateUser.getId());
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        if(bCryptPasswordEncoder.matches(passwordLogin, user.getPassword())) {
            UserData us =  userService.updateUser(updateUser);
            return ResponseEntity.ok(us);
        }
        return ResponseEntity.ok("Invalid login");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id,
                                             @RequestHeader("password") String passwordLogin){
        UserData user = userService.getUserById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        if(bCryptPasswordEncoder.matches(passwordLogin, user.getPassword())){
            String status = userService.deleteUser(id);
            return ResponseEntity.ok(status);
        }
        return ResponseEntity.ok("Invalid login");
    }
}
