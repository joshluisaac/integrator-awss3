package com.avantsystems.integrator.backup;


import com.avantsystems.integrator.backup.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping(value="user")
    @ResponseBody
    public String user(@RequestParam String userName){
        return userService.getUser(userName).toString();
    }
}
