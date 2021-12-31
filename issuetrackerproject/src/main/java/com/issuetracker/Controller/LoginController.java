package com.issuetracker.Controller;

import com.issuetracker.DBConnect.IssueTrackerJDBCTemplate;
import com.issuetracker.Model.CompanyModel;
import com.issuetracker.Model.ProjectModel;
import com.issuetracker.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private ApplicationContext context;

    //Method for User Login
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginUser(@ModelAttribute("registerFormData") UserModel formData, BindingResult
            result , ModelMap model){
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        int login_value = issueTrackerJDBCTemplate.signIn(formData);
        if(login_value == 1){
            return "dashboard";
        }
        else{
            return "login";
        }
    }

    //Method to Register User
    @RequestMapping(value = "/registeruser", method = RequestMethod.GET)
    public String signUpUser(@ModelAttribute("registerFormData") CompanyModel formData, BindingResult
            result , ModelMap model){
        System.out.println(formData.getUsername());
        System.out.println(formData.getPassword());
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        issueTrackerJDBCTemplate.signUp(formData);

        System.out.println("registering user");
        return null;
    }

}
