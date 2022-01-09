package com.issuetracker.Mapper;

import com.issuetracker.Model.TicketDisplayModel;
import com.issuetracker.Model.TicketModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TicketDisplayMapper implements RowMapper<TicketDisplayModel> {


    @Override
    public TicketDisplayModel mapRow(ResultSet rs, int i) throws SQLException {
        TicketDisplayModel ticketDisplayModel = new TicketDisplayModel();
        ticketDisplayModel.setId(rs.getInt("id"));
        ticketDisplayModel.setTicket_name(rs.getString("ticket_name"));
        ticketDisplayModel.setTicket_description(rs.getString("ticket_description"));
        ticketDisplayModel.setTicket_priority(rs.getString("ticket_priority"));
        ticketDisplayModel.setStatus(rs.getString("status"));
        ticketDisplayModel.setAssigned_to(rs.getString("username"));
        ticketDisplayModel.setSubmitted_by(rs.getString("username1"));
        ticketDisplayModel.setProject_id(rs.getInt("project_id"));
        return ticketDisplayModel;
    }
}
