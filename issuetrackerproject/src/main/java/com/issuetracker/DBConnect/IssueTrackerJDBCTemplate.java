package com.issuetracker.DBConnect;

import com.issuetracker.Mapper.*;
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
    public List<TicketModel> getTicketByProjectID(CommonIDModel commonIDModel) {
        String SQL = "select * from ticket where project_id = ?";
        List <TicketModel> tickets = jdbcTemplateObject.query(SQL,new Object[]{commonIDModel.getId()}, new TicketMapper());
        return tickets;
    }

    @Override
    public List<TicketModel> getTicketByCompanyID(CommonIDModel commonIDModel) {
        String SQL = "select * from ticket inner join project on ticket.project_id = project.id and project.company_id = ?";
        List <TicketModel> tickets = jdbcTemplateObject.query(SQL,new Object[]{commonIDModel.getId()}, new TicketMapper());
        return tickets;
    }

    @Override
    public List<ProjectModel> getProject(CommonIDModel commonIDModel) {
        String SQL = "select * from project where company_id = ?";
        List <ProjectModel> projects = jdbcTemplateObject.query(SQL, new Object[]{commonIDModel.getId()}, new ProjectMapper());
        return projects;
    }

    @Override
    public List<ProjectModel> getProjectByID(CommonIDModel commonIDModel) {
        String SQL = "select * from project where id = ?";
        List <ProjectModel> projects = jdbcTemplateObject.query(SQL, new Object[]{commonIDModel.getId()}, new ProjectMapper());
        return projects;
    }
    @Override
    public List<TicketModel> getTicketByID(CommonIDModel commonIDModel) {
        String SQL = "select * from ticket where id = ?";
        List<TicketModel> tickets = jdbcTemplateObject.query(SQL, new Object[]{commonIDModel.getId()}, new TicketMapper());
        return tickets;
    }


    @Override
    public List<UserModel> getDeveloperByProjectID(CommonIDModel commonIDModel) {
        String SQL = "select * from user u inner join role_assignment r on r.user_id = u.id  where u.role = ? and r.project_id = ?";
        List<UserModel> tickets = jdbcTemplateObject.query(SQL, new Object[]{"developer", commonIDModel.getId()}, new UserMapper());
        return tickets;
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
        String SQL = "insert into user (username, password, email, role, company_id) values (?, ?, ?, ?, ?)";

        //System.out.println(userModel.getCompany_id());
        jdbcTemplateObject.update( SQL, userModel.getUsername(),userModel.getPassword(),userModel.getEmail(),userModel.getRole(),userModel.getCompany_id());
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
    public void roleAssignment( int user_id, String role) {
        String SQL = "update user set role = ? where id = ?";

        jdbcTemplateObject.update( SQL,role, user_id);
        System.out.println("Created Record Name ");
    }

    public void addUserToProject(AssignUserProjectModel assignUserProjectModel){
        String SQL = "select * from role_assignment where project_id = ? and user_id = ?";
        List<CountModel> countModel = jdbcTemplateObject.query(SQL, new Object[]{assignUserProjectModel.getProject_id(),assignUserProjectModel.getUser_id()}, new CountMapper());

        if(countModel.isEmpty()){
            String SQL1 = "insert into role_assignment (project_id, user_id) values (?, ?)";
            jdbcTemplateObject.update( SQL1, assignUserProjectModel.getProject_id(), assignUserProjectModel.getUser_id());
            System.out.println("Created Record Name ");
        }
        else{
            System.out.println("Data Already Exists");
        }

    }

    @Override
    public void updateUser() {

    }

    @Override
    public void updateTicket(TicketModel ticketModel) {
        String SQL = "update ticket set ticket_name=?,  ticket_description=?, ticket_priority=?, status=?, assigned_to=? where id = ?";
        jdbcTemplateObject.update( SQL,ticketModel.getTicket_name(), ticketModel.getTicket_description(), ticketModel.getTicket_priority(), ticketModel.getStatus(),ticketModel.getAssigned_to(),ticketModel.getId());
        System.out.println("Created Record Name ");
    }

    @Override
    public void updateDeveloperTicket(TicketModel ticketModel) {
        String SQL = "update ticket set status=?  where id = ?";
        jdbcTemplateObject.update( SQL, ticketModel.getStatus(), ticketModel.getId());
        System.out.println("Created Record Name ");
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
    public List<UserModel> signIn(UserModel userModel) {
        String SQL = "select * from user where username = ?";
        List<UserModel> users = jdbcTemplateObject.query(SQL,new Object[]{userModel.getUsername()}, new UserMapper());
        return users;
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

    @Override
    public List<RoleModel> getRole(CommonIDModel commonIDModel) {
        String SQL = "select username, role from user where company_id=?  ";
        List<RoleModel> roles = jdbcTemplateObject.query(SQL,new Object[]{commonIDModel.getId()}, new RoleMapper());
        return roles;
    }

    public List<RoleModel> getRoleForProject(CommonIDModel commonIDModel){
        String SQL = "select u.username, u.role from user u inner join role_assignment r  on u.id=r.user_id where r.project_id=?";
        List<RoleModel> roles = jdbcTemplateObject.query(SQL,new Object[]{commonIDModel.getId()}, new RoleMapper());
        return roles;
    }

    public List<TicketModel> getDeveloperTickets(CommonIDModel commonIDModel){
        String SQL = "select * from ticket where assigned_to=?  ";
        List<TicketModel> tickets = jdbcTemplateObject.query(SQL,new Object[]{commonIDModel.getId()}, new TicketMapper());
        return tickets;
    }

    public List<TicketDisplayModel> getPMTickets(CommonIDModel commonIDModel){
        String SQL = "select t.id, t.ticket_name, t.ticket_description, t.ticket_priority, t.status, u.username,u1.username as username1, t.project_id from ticket as t inner join role_assignment as r on t.project_id = r.project_id inner join user u on t.assigned_to=u.id inner join user u1 on t.submitter_id = u1.id where r.user_id=? ";
        List<TicketDisplayModel> tickets = jdbcTemplateObject.query(SQL,new Object[]{commonIDModel.getId()}, new TicketDisplayMapper());
        return tickets;
    }
}
