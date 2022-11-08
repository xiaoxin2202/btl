package com.example.demobtl.dao;

import com.example.demobtl.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DAO{
    public UserDAO() {
    }
    public User getUser(int userId){
        return new User();
    }

    public boolean checkLogin(User user) throws SQLException {
        boolean result = false;
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        System.out.println("pscon:"+con);
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getPassWord());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
                user.setID(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setExperience(rs.getFloat("experience"));
                user.setAge(rs.getInt("age"));
                result = true;
        }
        ps.close();
        rs.close();
        return result;
    }
}
