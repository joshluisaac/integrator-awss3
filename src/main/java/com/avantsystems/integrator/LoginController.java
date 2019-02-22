package com.avantsystems.integrator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {


    //@RequestMapping(value="/login",method = RequestMethod.POST)
    @GetMapping(value = "/login")
    public String login(){

        return "login";
    }


    @GetMapping(value = "/login1")
    @ResponseBody
    public String login2(){

        return "from login response";
    }



}
