package com.issuetracker.Controller;

import com.google.gson.Gson;
import com.issuetracker.DBConnect.IssueTrackerJDBCTemplate;
import com.issuetracker.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

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

        if(login_value == -1){
            model.addAttribute("message", "User Doesn't Exist!");
            return "login";
        } else if(login_value == 0){
            model.addAttribute("message", "Invalid Password!");
            return "login";
        }else{
            System.out.println("hello");
            model.addAttribute("company_id",login_value );
            return "dashboard";
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

        return "login";
    }

    @RequestMapping(value = "/checkuserexist", method = RequestMethod.POST)
    public @ResponseBody String checkUserExist(@RequestBody UserValidateModel userData, BindingResult
            result , ModelMap model){
        System.out.println("Hello");
        System.out.println(userData.getUsername());
        ManageRoleModel manageRoleModel = new ManageRoleModel();
        manageRoleModel.setUsername(userData.getUsername());
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        List<UserModel> users = issueTrackerJDBCTemplate.getUserByName(manageRoleModel);
        System.out.println("Hello from here");
        if(users.isEmpty()){
            System.out.println("User doesn't exists");
            userData.setUser_exist(FALSE);
        }
        else{
            userData.setUser_exist(TRUE);
            System.out.println("User Exist");
        }
        System.out.println("Hello22");

        Gson gson = new Gson();
        String json = gson.toJson(userData);
        return json;
    }
}
