package com.prolific.software.foodappbackend.controller;

import com.prolific.software.foodappbackend.model.UserAccount;
import com.prolific.software.foodappbackend.repository.UserAccountRepository;
import com.prolific.software.foodappbackend.response.ResponseWrapper;
import com.prolific.software.foodappbackend.security.User;
import com.prolific.software.foodappbackend.utils.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

@RestController
public class AuthController {

    @Autowired
    UserAccountRepository userAccountRepository;

    @RequestMapping("/login")
    public ResponseWrapper login(@RequestBody UserAccount user) {
        List<UserAccount> userAccounts = userAccountRepository.findByUsername(user.getUsername());
        if (userAccounts.size() == 0){
            return ResponseWrapper.failure();
        }else if (userAccounts.size() == 1){
            userAccounts.get(0).setToken(new RandomString().nextString());
            userAccountRepository.save(userAccounts.get(0));
            return ResponseWrapper.success(userAccounts.get(0));
        }else {
            return ResponseWrapper.failure();
        }
    }

    @RequestMapping("/signup")
    public ResponseWrapper signup(@RequestBody UserAccount user){
        if (userAccountRepository.findByUsername(user.getUsername()).size() > 0){
            return ResponseWrapper.failure();
        }else {
            user.setToken(new RandomString().nextString());
            userAccountRepository.save(user);
            return ResponseWrapper.success(user);
        }
    }
}
