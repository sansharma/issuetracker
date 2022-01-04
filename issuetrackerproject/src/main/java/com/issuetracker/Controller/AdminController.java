package com.issuetracker.Controller;

import com.issuetracker.DBConnect.IssueTrackerJDBCTemplate;
import com.issuetracker.Model.*;
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
public class AdminController {

    @Autowired
    private ApplicationContext context;

    public String getTicketDetails(){
        return null;
    }

    public String getProjectDetails(){
        return null;
    }

    @RequestMapping(value = "/userdetails", method = RequestMethod.GET)
    public String getUserDetails(@ModelAttribute("adminFormData") CommonIDModel formData, BindingResult
            result , ModelMap model){
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        List<UserModel> users = issueTrackerJDBCTemplate.getUser(formData);
        for(UserModel user: users){
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
        }
        return "dashboard";
    }

    @RequestMapping(value = "/adduserrole", method = RequestMethod.GET)
    public String addUserRole(@ModelAttribute("addUserRoleData")ManageRoleModel formData, BindingResult
            result , ModelMap model){

        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        System.out.println(formData.getProject_name());
        List<UserModel> users = issueTrackerJDBCTemplate.getUserByName(formData);
        List<ProjectModel> projects = issueTrackerJDBCTemplate.getProjectByName(formData);

        int user_id = users.get(0).getId();
        int project_id = projects.get(0).getId();
        issueTrackerJDBCTemplate.roleAssignment(project_id, user_id, formData.getRole());
        return null;
    }


    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String addUser(@ModelAttribute("addUserFormData") UserModel formData, BindingResult
            result , ModelMap model){
        System.out.println(formData.getCompany_id());
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        issueTrackerJDBCTemplate.createUser(formData);

        return null;
    }

    public String addTicket(){
        return null;
    }

    public String addProject(){
        return null;
    }

}
