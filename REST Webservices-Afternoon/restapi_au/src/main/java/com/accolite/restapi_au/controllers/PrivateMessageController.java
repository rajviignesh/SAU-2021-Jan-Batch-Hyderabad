package com.accolite.restapi_au.controllers;

import com.accolite.restapi_au.entity.PrivateMessage;
import com.accolite.restapi_au.entity.UserData;
import com.accolite.restapi_au.repository.PrivateMessageRepo;
import com.accolite.restapi_au.service.PrivateMessageService;
import com.accolite.restapi_au.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

//ResponseEntity<Object>



@RestController
@RequestMapping("/api/message")
public class PrivateMessageController {

    @Autowired
    UserService userService;

    @Autowired
    PrivateMessageService privateMessageService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/add/{UserId}")
    public ResponseEntity<Object> postMessage(@RequestBody PrivateMessage privateMessage,
                                              @PathVariable("UserId") Integer userID){

        UserData user = userService.getUserById(userID);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        privateMessage.setUser(user);
        PrivateMessage createMessage = privateMessageService.add(privateMessage);
        return new ResponseEntity<Object>(createMessage, HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/get/{UserId}")
    public ResponseEntity<Object> getMessage(@PathVariable("UserId") Integer userID,
                                             @RequestHeader("password") String password) {

        UserData user = userService.getUserById(userID);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        if(bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.ok(privateMessageService.getMessages(userID));
        }
        return ResponseEntity.ok("Invalid login");
    }

}
