package com.issuetracker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageRedirectController {
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignUpPage(){
        return "register";
    }

}
