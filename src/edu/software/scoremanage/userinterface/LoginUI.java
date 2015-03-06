package edu.software.scoremanage.userinterface;

import edu.software.scoremanage.transaction.LoginController;
import edu.software.scoremanage.util.DataHelper;
import static edu.software.scoremanage.util.MyIO.*;

public class LoginUI {
	
	static LoginController lc;
	
	public static void main(String[] args){
		
		DataHelper.setUp();
		
		lc = new LoginController();
		
		loop:while(true){
			println("Please enter number to choose:\n"
					+"1:Administrator Login\n"
					+"2:Student Login\n"
					+"3:Teacher Login\n"
					+"4:Quit");
			switch(scanInt()){
			case 1:
				println("Please enter the login name:");
				String l1 = scanString();
				println("Please enter the password");
				String p1 = scanString();
				if(lc.verifyAdmin(l1, p1)){
					lc.adminLogin();
				}else{
					println("Login Fail!");
				}
				break;
			case 2:
				println("Please enter the login name:");
				String l2 = scanString();
				println("Please enter the password");
				String p2 = scanString();
				if(lc.verifyStudent(l2, p2)){
					lc.studentLogin(l2);
				}else{
					println("Login Fail!");
				}
				break;
			case 3:
				println("Please enter the login name:");
				String l3 = scanString();
				println("Please enter the password");
				String p3 = scanString();
				if(lc.verifyTeacher(l3, p3)){
					lc.teacherLogin(l3);
				}else{
					println("Login Fail!");
				}
				break;
			case 4:
				break loop;
			default:
				println("Wrong input.Please choose a number between 1,2,3,4");
			}
		}
	}

}
