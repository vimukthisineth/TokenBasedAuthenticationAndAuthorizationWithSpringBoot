package com.prolific.software.foodappbackend.controller;

import com.prolific.software.foodappbackend.model.UserAccount;
import com.prolific.software.foodappbackend.repository.UserAccountRepository;
import com.prolific.software.foodappbackend.response.ResponseWrapper;
import com.prolific.software.foodappbackend.utils.Login;
import com.prolific.software.foodappbackend.utils.RandomString;
import com.prolific.software.foodappbackend.utils.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {

    @Autowired
    UserAccountRepository userAccountRepository;

    @RequestMapping("/login")
    public ResponseWrapper login(@RequestBody Login login) {
        List<UserAccount> userAccounts = userAccountRepository.findByUsername(login.getUsername());
        if (userAccounts.size() == 0){
            return ResponseWrapper.failure();
        }else if (userAccounts.size() == 1){
            if (userAccounts.get(0).getPassword().equals(login.getPassword())){
                userAccounts.get(0).setToken(new RandomString().nextString());
                userAccountRepository.save(userAccounts.get(0));
                return ResponseWrapper.success(userAccounts.get(0));
            }else {
                return ResponseWrapper.failure();
            }
        }else {
            return ResponseWrapper.failure();
        }
    }

    @RequestMapping("/signup")
    public ResponseWrapper signup(@RequestBody Signup signup){
        if (userAccountRepository.findByUsername(signup.getUsername()).size() > 0){
            return ResponseWrapper.failure();
        }else {
            UserAccount user = new UserAccount(signup.getUsername(), signup.getPassword(), new RandomString().nextString(), signup.getFirstName(), signup.getLastName(), signup.getEmail());
            userAccountRepository.save(user);
            return ResponseWrapper.success(user);
        }
    }
}
