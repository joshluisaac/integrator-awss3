package com.avantsystems.integrator.security;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {


    @GetMapping("/register")
    public String register(@RequestParam String email ) {
        return "register";
    }

}



