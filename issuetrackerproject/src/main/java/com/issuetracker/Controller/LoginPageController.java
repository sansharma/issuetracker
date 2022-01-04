package com.issuetracker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginPageController {

    @RequestMapping(method = RequestMethod.GET)
    public String getLoginPage(){
        return "dashboard";
    }

}
