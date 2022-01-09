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

import java.awt.*;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ApplicationContext context;

    public String getTicketDetails(){
        return null;
    }

    @RequestMapping(value = "/projectdetails", method = RequestMethod.GET)
    public String getProjectDetails(@RequestParam("id") int id, @RequestParam("company_id") int company_id, ModelMap model){
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        CommonIDModel commonIDModel = new CommonIDModel();
        commonIDModel.setId(id);
        List<ProjectModel> projects = issueTrackerJDBCTemplate.getProjectByID(commonIDModel);
        List<TicketModel> tickets = issueTrackerJDBCTemplate.getTicketByProjectID(commonIDModel);
        List<RoleModel> roles = issueTrackerJDBCTemplate.getRoleForProject(commonIDModel);
        ProjectModel project = projects.get(0);
        //System.out.println(roles.get(0).username);
        model.addAttribute("company_id", company_id);
        model.addAttribute("roles",roles);
        model.addAttribute("project",project);
        model.addAttribute("tickets",tickets);
        return "project-details";
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
       // System.out.println(formData.getProject_name());
        //List<UserModel> users = issueTrackerJDBCTemplate.getUserByName(formData);
        //List<ProjectModel> projects = issueTrackerJDBCTemplate.getProjectByName(formData);

        issueTrackerJDBCTemplate.roleAssignment( formData.getUser_id(), formData.getRole());
        return "forward:/managerolepage?id="+formData.getCompany_id();
    }

    @RequestMapping(value = "/developerticketspage", method = RequestMethod.GET)
    public String getDeveloperTickets(@RequestParam("id") int id, @RequestParam("company_id") int company_id, ModelMap model){
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");

        CommonIDModel commonIDModel = new CommonIDModel();
        commonIDModel.setId(id);
        List<TicketModel> tickets = issueTrackerJDBCTemplate.getDeveloperTickets(commonIDModel);
        model.addAttribute("user_id",id);
        model.addAttribute("company_id",company_id);
        model.addAttribute("tickets", tickets);
        return "mytickets-developer";
    }

    @RequestMapping(value = "/pmticketspage", method = RequestMethod.GET)
    public String getPMTickets(@RequestParam("id") int id, @RequestParam("company_id") int company_id, ModelMap model){
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        CommonIDModel commonIDModel = new CommonIDModel();
        commonIDModel.setId(id);
        List<TicketDisplayModel> tickets = issueTrackerJDBCTemplate.getPMTickets(commonIDModel);
        model.addAttribute("tickets", tickets);
        model.addAttribute("user_id",id);
        model.addAttribute("company_id",company_id);
        return "mytickets-pm";
    }

    @RequestMapping(value = "/getTicketForPopUp", method = RequestMethod.POST)
    public @ResponseBody String getTicketForPopUp(@RequestBody CommonIDModel commonIDModel, BindingResult
            result , ModelMap model){
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        System.out.println("hello from here");
        List<TicketModel> tickets = issueTrackerJDBCTemplate.getTicketByID(commonIDModel);
        System.out.println("How about here");
        Gson gson = new Gson();
        String json = gson.toJson(tickets.get(0));
        return json;
    }

    @RequestMapping(value = "/getDeveloperForPopUp", method = RequestMethod.POST)
    public @ResponseBody String getDeveloperForPopUp(@RequestBody CommonIDModel commonIDModel, BindingResult
            result , ModelMap model){
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        System.out.println("hello from here");
        List<UserModel> developers = issueTrackerJDBCTemplate.getDeveloperByProjectID(commonIDModel);
        System.out.println("How about here");
        Gson gson = new Gson();
        String json = gson.toJson(developers);
        return json;
    }


    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String addUser(@ModelAttribute("addUserFormData") UserModel formData, BindingResult
            result , ModelMap model){
        System.out.println(formData.getCompany_id());
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        issueTrackerJDBCTemplate.createUser(formData);
        return "forward:/managerolepage?id="+formData.getCompany_id();
    }


    @RequestMapping(value = "/addproject", method = RequestMethod.GET)
    public String addProject(@ModelAttribute("addProjectData") ProjectModel projectModel, BindingResult
            result , ModelMap model){
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        issueTrackerJDBCTemplate.createProject(projectModel);
        return "forward:/adminprojectpage?getid="+projectModel.getCompany_id();
    }

    @RequestMapping(value = "/addticket", method = RequestMethod.GET)
    public String addTicket(@ModelAttribute("addTicketData") TicketModel ticketModel, BindingResult
            result , ModelMap model){
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        CommonIDModel commonIDModel = new CommonIDModel();
        commonIDModel.setId(ticketModel.getProject_id());
        List<ProjectModel> projects = issueTrackerJDBCTemplate.getProjectByID(commonIDModel);
        ProjectModel project = projects.get(0);
        issueTrackerJDBCTemplate.createTicket(ticketModel);
        return "forward:/adminticketpage?getid="+project.getCompany_id()+"&user_id="+ticketModel.getSubmitter_id();
    }

    @RequestMapping(value = "/addusertoproject", method = RequestMethod.GET)
    public String addUserToProject(@ModelAttribute("addUserProjectData") AssignUserProjectModel assignUserProjectModel, BindingResult
            result , ModelMap model){
        System.out.println("hello");
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        issueTrackerJDBCTemplate.addUserToProject(assignUserProjectModel);
        return "forward:/projectdetails?id="+assignUserProjectModel.getProject_id()+"&company_id="+assignUserProjectModel.getCompany_id();
    }

    @RequestMapping(value = "/updateTicket", method = RequestMethod.GET)
    public String updateTicket(@ModelAttribute("updateTicketFormData") TicketModel ticketModel, BindingResult
            result , ModelMap model){
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        issueTrackerJDBCTemplate.updateTicket(ticketModel);
        System.out.println("what's up?");
        return"forward:/pmticketspage?id="+ticketModel.getSubmitter_id()+"&company_id="+ticketModel.getProject_id();
    }

    @RequestMapping(value = "/updateDeveloperTicket", method = RequestMethod.GET)
    public String updateDeveloperTicket(@ModelAttribute("addTicketStatusData") TicketModel ticketModel, BindingResult
            result , ModelMap model){
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        issueTrackerJDBCTemplate.updateDeveloperTicket(ticketModel);
        return"forward:/developerticketspage?id="+ticketModel.getSubmitter_id()+"&company_id="+ticketModel.getProject_id();
    }

}


