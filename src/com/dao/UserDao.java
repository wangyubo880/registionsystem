package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.User;
import com.db.DBConnection;

public class UserDao {
	public boolean register(String username,String userpassword) {

		Connection connection = DBConnection.getConnection();
		PreparedStatement ps =null;
		try {
			 ps = connection.prepareStatement("INSERT INTO userlogin(username,userpassword) VALUE(?,?);");
			 ps.setString(1, username);
			 ps.setString(2,userpassword);
			 ps.execute();
			 return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	public User login(String username,String userpassword) {
		User user = null;
		Connection connection = DBConnection.getConnection();
		PreparedStatement ps =null;
		ResultSet rs=null;
		try {
			 ps = connection.prepareStatement("select * from userlogin where username=? and userpassword=?");
			 ps.setString(1, username);
			 ps.setString(2,userpassword);
			 rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(username);
				user.setUserpassword(userpassword);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

}
