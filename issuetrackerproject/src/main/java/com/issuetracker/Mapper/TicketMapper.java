package com.issuetracker.Mapper;

import com.issuetracker.Model.TicketModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketMapper implements RowMapper<TicketModel> {
    @Override
    public TicketModel mapRow(ResultSet rs, int i) throws SQLException {
        TicketModel ticketModel = new TicketModel();
        ticketModel.setId(rs.getInt("id"));
        ticketModel.setTicket_name(rs.getString("ticket_name"));
        ticketModel.setTicket_description(rs.getString("ticket_description"));
        ticketModel.setTicket_priority(rs.getString("ticket_priority"));
        ticketModel.setStatus(rs.getString("status"));
        ticketModel.setAssigned_to(rs.getInt("assigned_to"));
        ticketModel.setSubmitter_id(rs.getInt("submitter_id"));
        ticketModel.setProject_id(rs.getInt("project_id"));
        return ticketModel;
    }
}
