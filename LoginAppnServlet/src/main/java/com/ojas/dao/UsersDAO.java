package com.ojas.dao;

import com.ojas.model.Users;

public interface UsersDAO {
	public String register(Users user);
	public String login(String userName, String passWord);
	public String forgot(String userName, String type);

}

