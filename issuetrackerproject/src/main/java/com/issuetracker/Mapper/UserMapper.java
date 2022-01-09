package com.issuetracker.Mapper;

import com.issuetracker.Model.UserModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet rs, int i) throws SQLException {
        UserModel userModel = new UserModel();
        userModel.setId(rs.getInt("id"));
        userModel.setUsername(rs.getString("username"));
        userModel.setPassword(rs.getString("password"));
        userModel.setEmail(rs.getString("email"));
        userModel.setRole(rs.getString("role"));
        userModel.setCompany_id(rs.getInt("company_id"));
        return userModel;
    }
}
