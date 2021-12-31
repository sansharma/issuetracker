package com.issuetracker.DBConnect;

import com.issuetracker.Mapper.ProjectMapper;
import com.issuetracker.Mapper.TicketMapper;
import com.issuetracker.Mapper.UserMapper;
import com.issuetracker.Model.CompanyModel;
import com.issuetracker.Model.ProjectModel;
import com.issuetracker.Model.TicketModel;
import com.issuetracker.Model.UserModel;
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
    public List<UserModel> getUser() {
        String SQL = "select * from user";
        List <UserModel> users = jdbcTemplateObject.query(SQL, new UserMapper());
        return users;
    }

    @Override
    public List<TicketModel> getTicket() {
        String SQL = "select * from ticket";
        List <TicketModel> tickets = jdbcTemplateObject.query(SQL, new TicketMapper());
        return tickets;
    }

    @Override
    public List<ProjectModel> getProject() {
        String SQL = "select * from project";
        List <ProjectModel> projects = jdbcTemplateObject.query(SQL, new ProjectMapper());
        return projects;
    }

    @Override
    public void createUser(String username, String password, String email, String role, int company_id) {
        String SQL = "insert into user (username, password, email, role, company_id) values (?, ?, ?, ?, ?)";

        jdbcTemplateObject.update( SQL, username, password, email, role, company_id);
        System.out.println("Created Record Name = " + username + " Age = " + password);
        return;
    }

    @Override
    public void createTicket(String ticket_name, String ticket_description, String ticket_priority, String status, int assigned_to, int submitter_id, int project_id) {
        String SQL = "insert into ticket (ticket_name, ticket_description, ticket_priority, status, assigned_to,submitter_id, project_id) values (?, ?, ?, ?, ?,?,?)";

        jdbcTemplateObject.update( SQL, ticket_name, ticket_description, ticket_priority, status, assigned_to, submitter_id, project_id);
        System.out.println("Created Record Name ");
        return;
    }

    @Override
    public void createProject(String project_name, String start_date, int company_id) {
        String SQL = "insert into project (project_name, start_date, company_id) values (?, ?, ?)";

        jdbcTemplateObject.update( SQL, project_name, start_date, company_id);
        System.out.println("Created Record Name ");
        return;
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
        if(users != null){
            UserModel user = users.get(0);
            if(user.getPassword().equals( userModel.getPassword())){
                System.out.println("Login Successful");
                return 1;
            }
            else{
                System.out.println("Invalid Password");
                return 0;
            }
        }
        else{
            System.out.println("User Doesn't Exist");
            return 2;
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
