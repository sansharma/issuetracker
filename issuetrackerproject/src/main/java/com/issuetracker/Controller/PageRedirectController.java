package com.issuetracker.Controller;

import com.issuetracker.DBConnect.IssueTrackerJDBCTemplate;
import com.issuetracker.Model.CommonIDModel;
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
public class PageRedirectController {
    @Autowired
    private ApplicationContext context;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignUpPage(){
        return "register";
    }

    @RequestMapping(value = "/managerolepage", method = RequestMethod.GET)
    public String getManageRolePage(@ModelAttribute("getRoleManageData") CommonIDModel commonIDModel, BindingResult
            result , ModelMap model){
        IssueTrackerJDBCTemplate issueTrackerJDBCTemplate = (IssueTrackerJDBCTemplate) context.getBean("issueTrackerJDBCTemplate");
        List<UserModel> users = issueTrackerJDBCTemplate.getUser(commonIDModel);
        List<ProjectModel> projects = issueTrackerJDBCTemplate.getProject(commonIDModel);
        model.addAttribute("users",users );
        model.addAttribute("projects", projects);
        return "managerole";
    }

}
