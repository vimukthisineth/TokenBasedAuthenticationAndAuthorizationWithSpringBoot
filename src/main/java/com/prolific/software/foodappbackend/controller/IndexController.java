package com.prolific.software.foodappbackend.controller;

import com.prolific.software.foodappbackend.security.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin
public class IndexController {

    @GetMapping(path = "/test", produces = "application/json")
    public String testRest(){
        return "Test success";
    }



}
