package com.issuetracker.Controller;

import com.google.gson.Gson;
import com.issuetracker.DBConnect.IssueTrackerJDBCTemplate;
import com.issuetracker.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PageRedirectController {
    @Autowired
    private ApplicationContext context;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignUpPage(){
        return "register";
    }

    @RequestMapping(value = "/admindashboard", method = RequestMethod.GET)
    public String getAdminDashboard(@RequestParam("user_id") int user_id, @RequestParam("company_id") int company_id, ModelMap model){
       UserModel user = new UserModel();
       user.setId(user_id);
       user.setCompany_id(company_id);
       model.addAttribute("user", user);
       return "dashboard";
    }

    @RequestMapping(value = "/managerolepage", method = RequestMethod.GET)
    public String getManageRolePage(@RequestParam("user_id") int user_id, @RequestParam("company_id") int company_id, ModelMap model){
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        CommonIDModel commonIDModel = new CommonIDModel();
        commonIDModel.setId(company_id);
        List<UserModel> users = issueTrackerJDBCTemplate.getUser(commonIDModel);
        List<ProjectModel> projects = issueTrackerJDBCTemplate.getProject(commonIDModel);
        List<RoleModel> roles = issueTrackerJDBCTemplate.getRole(commonIDModel);
        model.addAttribute("user_id", user_id);
        model.addAttribute("company_id",company_id);
        model.addAttribute("users",users );
        model.addAttribute("projects", projects);
        model.addAttribute("roles",roles);
        return "managerole";
    }

    @RequestMapping(value = "/adminprojectpage", method = RequestMethod.GET)
    public  String getMyProjectPage(@RequestParam("user_id") int user_id, @RequestParam("company_id") int company_id, ModelMap model){
              CommonIDModel commonIDModel = new CommonIDModel();
              commonIDModel.setId(company_id);
            IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
            List<ProjectModel> projects = issueTrackerJDBCTemplate.getProject(commonIDModel);
            model.addAttribute("user_id",user_id);
            model.addAttribute("company_id",company_id);
            model.addAttribute("projects", projects);
            System.out.println(commonIDModel.getId());
            return "myprojects-admin";

    }

    @RequestMapping(value = "/getProjectforPopUp", method = RequestMethod.POST)
    public @ResponseBody String getProjectforPopUp(@RequestBody CommonIDModel commonIDModel, BindingResult
            result , ModelMap model){
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        List<ProjectModel> projects = issueTrackerJDBCTemplate.getProject(commonIDModel);

        Gson gson = new Gson();
        String json = gson.toJson(projects);
        return json;
    }


    @RequestMapping(value = "/getUserforPopUp", method = RequestMethod.POST)
    public @ResponseBody String getUserforPopUp(@RequestBody CommonIDModel commonIDModel, BindingResult
            result , ModelMap model){
        System.out.println("hello1");
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        List<UserModel> users = issueTrackerJDBCTemplate.getUser(commonIDModel);

        Gson gson = new Gson();
        String json = gson.toJson(users);
        System.out.println(json);
        return json;
    }


    @RequestMapping(value = "/adminticketpage", method = RequestMethod.GET)
    public String getMyTicketsPage(@RequestParam("user_id") int user_id, @RequestParam("company_id") int company_id, ModelMap model){
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        CommonIDModel commonIDModel = new CommonIDModel();
        commonIDModel.setId(company_id);
        List<TicketModel> tickets = issueTrackerJDBCTemplate.getTicketByCompanyID(commonIDModel);
        model.addAttribute("user_id", user_id);
        model.addAttribute("company_id",company_id);
        model.addAttribute("tickets",tickets);
        return "mytickets-admin";
    }

    @RequestMapping(value = "/adminprofilepage", method = RequestMethod.GET)
    public String getMyProfilePage(@RequestParam("user_id") int user_id, @RequestParam("company_id") int company_id, ModelMap model){
        model.addAttribute("user_id",user_id);
        model.addAttribute("company_id",company_id);
        return "myprofile-admin";

    }

    @RequestMapping(value = "/adminhelppage", method = RequestMethod.GET)
    public String getHelpPage(@RequestParam("user_id") int user_id, @RequestParam("company_id") int company_id, ModelMap model){
        model.addAttribute("user_id",user_id);
        model.addAttribute("company_id",company_id);
        return "help-admin";
    }


}
