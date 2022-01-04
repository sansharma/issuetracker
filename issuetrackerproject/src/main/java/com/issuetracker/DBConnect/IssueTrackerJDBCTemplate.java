package com.issuetracker.DBConnect;

import com.issuetracker.Mapper.ProjectMapper;
import com.issuetracker.Mapper.TicketMapper;
import com.issuetracker.Mapper.UserMapper;
import com.issuetracker.Model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class IssueTrackerJDBCTemplate implements IssueTrackerDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<UserModel> getUser(CommonIDModel commonIDModel) {
        String SQL = "select * from user where company_id = ?";
        List <UserModel> users = jdbcTemplateObject.query(SQL,new Object[]{commonIDModel.getId()}, new UserMapper());
        return users;
    }

    @Override
    public List<TicketModel> getTicket(CommonIDModel commonIDModel) {
        String SQL = "select * from ticket";
        List <TicketModel> tickets = jdbcTemplateObject.query(SQL, new TicketMapper());
        return tickets;
    }

    @Override
    public List<ProjectModel> getProject(CommonIDModel commonIDModel) {
        String SQL = "select * from project where company_id = ?";
        List <ProjectModel> projects = jdbcTemplateObject.query(SQL, new Object[]{commonIDModel.getId()}, new ProjectMapper());
        return projects;
    }

    @Override
    public List<UserModel> getUserByName(ManageRoleModel manageRoleModel) {
        String SQL = "select * from user where username = ?";
        System.out.println("hello1");
        List <UserModel> users = jdbcTemplateObject.query(SQL,new Object[]{manageRoleModel.getUsername()}, new UserMapper());
        return users;
    }

    @Override
    public List<ProjectModel> getProjectByName(ManageRoleModel manageRoleModel) {
        System.out.println("Hello");
        System.out.println(manageRoleModel.getProject_name());
        String SQL = "select * from project where project_name = ?";
        List <ProjectModel> projects = jdbcTemplateObject.query(SQL, new Object[]{manageRoleModel.getProject_name()}, new ProjectMapper());
        System.out.println(projects.get(0).getProject_name());
        System.out.println("Hello");
        return projects;
    }

    @Override
    public void createUser(UserModel userModel) {
        String SQL = "insert into user (username, password, email, privilege, company_id) values (?, ?, ?, ?, ?)";

        //System.out.println(userModel.getCompany_id());
        jdbcTemplateObject.update( SQL, userModel.getUsername(),userModel.getPassword(),userModel.getEmail(),userModel.getPrivilege(),userModel.getCompany_id());
        System.out.println("Created Record Name = ");
        return;
    }

    @Override
    public void createTicket(TicketModel ticketModel) {
        String SQL = "insert into ticket (ticket_name, ticket_description, ticket_priority, status, assigned_to,submitter_id, project_id) values (?, ?, ?, ?, ?,?,?)";

        jdbcTemplateObject.update( SQL, ticketModel.getTicket_name(),ticketModel.getTicket_description(),ticketModel.getTicket_priority(),ticketModel.getStatus(),ticketModel.getAssigned_to(),ticketModel.getSubmitter_id(),ticketModel.getProject_id());
        System.out.println("Created Record Name ");
        return;
    }

    @Override
    public void createProject(ProjectModel projectModel) {
        String SQL = "insert into project (project_name, start_date, company_id) values (?, ?, ?)";

        jdbcTemplateObject.update( SQL, projectModel.getProject_name(),projectModel.getStart_date(),projectModel.getCompany_id());
        System.out.println("Created Record Name ");
    }

    @Override
    public void roleAssignment(int project_id, int user_id, String role) {
        String SQL = "insert into role_assignment (project_id, user_id, role) values (?, ?, ?)";

        jdbcTemplateObject.update( SQL, project_id, user_id, role);
        System.out.println("Created Record Name ");
    }

    @Override
    public void updateUser() {

    }

    @Override
    public void updateTicket() {

    }

    @Override
    public void updateProject() {

    }

    @Override
    public void deleteUser() {

    }

    @Override
    public void deleteTicket() {

    }

    @Override
    public void deleteProject() {

    }

    @Override
    public void signUp(final CompanyModel companyModel) {
        String SQL = "insert into company (company_name, username, password, email) values (?, ?, ?,?)";

       // jdbcTemplateObject.update( SQL, companyModel.getCompany_name(), companyModel.getUsername(), companyModel.getPassword(),companyModel.getEmail());


        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplateObject.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, companyModel.getCompany_name());
            ps.setString(2, companyModel.getUsername());
            ps.setString(3, companyModel.getPassword());
            ps.setString(4, companyModel.getEmail());
            return ps;
        }, keyHolder);

        System.out.println(keyHolder.getKey());

        String SQL1 = "insert into user (username, password, email, privilege, company_id) values (?, ?, ?,?,?)";

        jdbcTemplateObject.update( SQL1, companyModel.getUsername(), companyModel.getPassword(), companyModel.getEmail(),0,keyHolder.getKey());
        System.out.println("Created Record Name ");
        return;
    }

    @Override
    public int signIn(UserModel userModel) {
        String SQL = "select * from user where username = ?";
        List<UserModel> users = jdbcTemplateObject.query(SQL,new Object[]{userModel.getUsername()}, new UserMapper());
        if(users.isEmpty()){
            System.out.println("User Doesn't Exist");
            return -1;
        }else{
            UserModel user = users.get(0);
            if(user.getPassword().equals( userModel.getPassword())){
                System.out.println("Login Successful");
                System.out.println(user.getCompany_id());
                return user.getCompany_id();
            }
            else{
                System.out.println("Invalid Password");
                return 0;
            }
        }
    }

    @Override
    public List<ProjectModel> getMyProjects() {
        return null;
    }

    @Override
    public List<TicketModel> getDeveloperTickets() {
        return null;
    }

    @Override
    public List<TicketModel> getTesterTickets() {
        return null;
    }

    @Override
    public List<TicketModel> getProjectManagerTickets() {
        return null;
    }

}
