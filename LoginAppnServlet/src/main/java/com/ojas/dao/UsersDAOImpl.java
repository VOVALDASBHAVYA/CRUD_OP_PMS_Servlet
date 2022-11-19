package com.ojas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ojas.db.DBUtility;
import com.ojas.model.Users;
import com.ojas.query.Query;

public class UsersDAOImpl implements UsersDAO {
	
	public Connection con=DBUtility.getConnection();
	PreparedStatement ps=null;
	String message=null;
	ResultSet rs=null;
	int effectedRows=0;

	public String register(Users user) {
		try {
			ps=con.prepareStatement(Query.INSERT_USER);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassWord());
			ps.setString(3, user.getType());
			effectedRows=ps.executeUpdate();
			if(effectedRows != 0){
				message = "success";
			}else{
				message ="failed";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public String login(String userName, String passWord) {
		String type=null;
		try {
			ps=con.prepareStatement(Query.GET_USER);
			ps.setString(1, userName);
			ps.setString(2, passWord);
			rs=ps.executeQuery();
			if(rs.next()){
				type=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
	}

	public String forgot(String userName, String type) {
		String passWord=null;
		try {
			ps=con.prepareStatement(Query.GET_PASSWORD);
			ps.setString(1, userName);
			ps.setString(2, type);
			rs=ps.executeQuery();
			if(rs.next()){
				passWord=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return passWord;
	}

}
