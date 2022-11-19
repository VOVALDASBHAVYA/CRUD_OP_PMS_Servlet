package com.ojas.query;

public interface Query {
	
	public String INSERT_USER = "INSERT INTO USERS(USERNAME,PASSWORD,TYPE) VALUES(?,?,?)";
	
	public String GET_USER = "SELECT TYPE FROM USERS WHERE USERNAME=? AND PASSWORD=?";
	
	public String GET_PASSWORD = "SELECT PASSWORD FROM USERS WHERE USERNAME=? AND TYPE=?";
	

}
