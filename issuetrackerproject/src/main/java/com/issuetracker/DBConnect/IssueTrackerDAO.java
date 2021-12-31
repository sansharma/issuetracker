package com.issuetracker.DBConnect;

import com.issuetracker.Model.CompanyModel;
import com.issuetracker.Model.ProjectModel;
import com.issuetracker.Model.TicketModel;
import com.issuetracker.Model.UserModel;

import javax.sql.DataSource;
import java.util.List;

public interface IssueTrackerDAO {
    public void setDataSource(DataSource ds);

    public List<UserModel> getUser();

    public List<TicketModel> getTicket();

    public List<ProjectModel> getProject();

    abstract void createUser(String username, String password, String email, String role, int company_id);

    public void createTicket(String ticket_name, String ticket_description, String ticket_priority, String status, int assigned_to, int submitter_id, int project_id);

    public void createProject(String project_name, String start_date, int company_id);

    public void updateUser();

    public void updateTicket();

    public void updateProject();

    public void deleteUser();

    public void deleteTicket();

    public void deleteProject();

    public void signUp(CompanyModel companyModel);

    public int signIn(UserModel userModel);
    // Project Manager

    public List<ProjectModel> getMyProjects();

    public List<TicketModel> getDeveloperTickets();
    public List<TicketModel> getTesterTickets();
    public List<TicketModel> getProjectManagerTickets();

}
