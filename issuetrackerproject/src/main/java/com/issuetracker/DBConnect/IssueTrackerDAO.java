package com.issuetracker.DBConnect;

import com.issuetracker.Model.*;

import javax.sql.DataSource;
import java.util.List;

public interface IssueTrackerDAO {
    public void setDataSource(DataSource ds);

    public List<UserModel> getUser(CommonIDModel commonIDModel);

    public List<TicketModel> getTicket(CommonIDModel commonIDModel);

    public List<ProjectModel> getProject(CommonIDModel commonIDModel);

    public List<UserModel> getUserByName(ManageRoleModel manageRoleModel);
    public List<ProjectModel> getProjectByName(ManageRoleModel manageRoleModel);

    public void roleAssignment(int project_id, int user_id, String role);

    abstract void createUser(UserModel userModel);

    public void createTicket(TicketModel ticketModel);

    public void createProject(ProjectModel projectModel);

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
