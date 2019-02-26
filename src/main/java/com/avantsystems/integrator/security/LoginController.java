package com.avantsystems.integrator.security;


import org.eclipse.jetty.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class LoginController {


    @GetMapping(value={"/","/login"})
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
    public Principal user(Principal principal, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
        System.out.println(session.getId());
        System.out.println(session.getCreationTime());
        System.out.println(session.getLastAccessedTime());
        System.out.println(session.getMaxInactiveInterval());
        System.out.println(session.getAttributeNames().toString());
        System.out.println("Authentication type: " + HttpStatus.);


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
