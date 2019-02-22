package com.avantsystems.integrator;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthenticationController {

  @GetMapping("auth")
  @ResponseBody
  public String auth(){
      return "from auth";
    }

}
