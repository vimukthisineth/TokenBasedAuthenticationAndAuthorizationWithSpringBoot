package com.prolific.software.foodappbackend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class IndexController {

    @GetMapping(path = "/test", produces = "application/json")
    public String testRest(){
        return "Test success";
    }
}
