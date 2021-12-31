package com.issuetracker.Mapper;

import com.issuetracker.Model.ProjectModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectMapper implements RowMapper<ProjectModel> {
    @Override
    public ProjectModel mapRow(ResultSet rs, int i) throws SQLException {
        ProjectModel projectModel = new ProjectModel();
        projectModel.setId(rs.getInt("id"));
        projectModel.setProject_name(rs.getString("project_name"));
        projectModel.setStart_date(rs.getString("start_date"));
        projectModel.setCompany_id(rs.getInt("company_id"));
        return projectModel;
    }
}
