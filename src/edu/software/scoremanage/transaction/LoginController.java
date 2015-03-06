package edu.software.scoremanage.transaction;

import edu.software.scoremanage.model.User;
import edu.software.scoremanage.userinterface.AdministratorUI;
import edu.software.scoremanage.userinterface.StudentUI;
import edu.software.scoremanage.userinterface.TeacherUI;

public class LoginController {
	
	User user = User.getInstance();
	
	public boolean verifyAdmin(String loginName,String password){
		return user.verifyAdmin(loginName, password);
	}
	public boolean verifyStudent(String loginName,String password){
		return user.verifyStudent(loginName, password);
	}
	public boolean verifyTeacher(String loginName,String password){
		return user.verifyTeacher(loginName, password);
	}
	
	public void adminLogin(){
		new AdministratorUI().mainMenu();
	}
	public void teacherLogin(String loginName){
		new TeacherUI(user.searchTeacher(loginName)).mainMenu();
	}
	public void studentLogin(String loginName){
		new StudentUI(user.searchStudent(loginName)).mainMenu();
	}

}
