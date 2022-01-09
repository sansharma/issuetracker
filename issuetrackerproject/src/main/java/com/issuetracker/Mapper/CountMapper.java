package com.issuetracker.Mapper;


import com.issuetracker.Model.CountModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountMapper implements RowMapper<CountModel> {

    @Override
    public CountModel mapRow(ResultSet rs, int i) throws SQLException {
        CountModel countModel = new CountModel();
        countModel.setId(rs.getInt("id"));
        countModel.setProject_id(rs.getInt("project_id"));
        countModel.setUser_id(rs.getInt("user_id"));
        return countModel;
    }
}
