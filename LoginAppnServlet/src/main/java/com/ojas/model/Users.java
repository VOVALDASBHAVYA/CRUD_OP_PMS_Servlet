package com.ojas.model;

public class Users {

	public int uid;

	public String userName;
	public String passWord;
	public String type;
	
	
	public Users(){
		
	}
	
	public Users(int uid, String userName, String passWord, String type) {
		this.uid = uid;
		this.userName = userName;
		this.passWord = passWord;
		this.type = type;
	}
	
	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassWord() {
		return passWord;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Users [uid=" + uid + ", userName=" + userName + ", passWord=" + passWord + ", type=" + type + "]";
	}
}
