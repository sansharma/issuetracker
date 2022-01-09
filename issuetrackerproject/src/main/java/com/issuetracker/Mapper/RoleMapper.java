package com.issuetracker.Mapper;

import com.issuetracker.Model.RoleModel;
import org.springframework.jdbc.core.RowMapper;

import javax.management.relation.Role;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RoleMapper implements RowMapper<RoleModel> {
    @Override
    public RoleModel mapRow(ResultSet rs, int i) throws SQLException {
        RoleModel roleModel = new RoleModel();
        roleModel.setUsername(rs.getString("username"));
        roleModel.setRole(rs.getString("role"));
        return roleModel;
    }
}
