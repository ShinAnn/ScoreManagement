package edu.software.scoremanage.model;

import java.io.Serializable;

/*
 * 类名：Administrator
 * 类描述：用户的一种类型
 * @author:Sissel
 * @version:2015-02-17 16:05:22
 */
public class Administrator implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//Both loginName,passWord,userName can consist of numbers and letters
	String loginName;
	String password;
	String userName;
	
    Administrator(String loginName,String password,String userName){
		this.loginName = loginName;
		this.password = password;
		this.userName = userName;
	}
	
	void editUserName(String newName){
		userName = newName;
	}
	
	void editPassword(String newPassword){
		password = newPassword;
	}
}
