package com.avantsystems.integrator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class LoginController {


    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/admin")
    @ResponseBody
    public Principal admin(Principal principal) {
        return principal;
    }

    @GetMapping("/user")
    @ResponseBody
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }


    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping(value = "dashboard")
    @ResponseBody
    public String dashboard(){
        return "Dashboard";
    }

}
