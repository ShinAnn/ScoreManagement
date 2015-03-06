package edu.software.scoremanage.userinterface;

import edu.software.scoremanage.model.Course;
import edu.software.scoremanage.transaction.AdministratorController;
import static edu.software.scoremanage.util.MyIO.*;
import static edu.software.scoremanage.util.GenerateCode.*;
import static edu.software.scoremanage.util.R.*;

public class AdministratorUI {
	
	AdministratorController ac = new AdministratorController();
	
	public void mainMenu(){
		loop:while(true){
			println(sTitle
					+"1:Manage Teachers\n"
					+"2:Manage Students\n"
					+"3:Manage Courses\n"
					+"4:Edit Personal Info\n"
					+"5:Log Out");
			
			switch(scanInt()){
			case 1: //Manage Teachers
				manageTeachers();
				break;
			case 2: //Manage Students
				manageStudents();
				break;
			case 3: //Manage Courses
				manageCourses();
				break;
			case 4: //Edit Personal Info
				editPersonalInfo();
				break;
			case 5: //Log Out
				ac.saveData();
				break loop;
			default:
				println(generateErrTips(5));
			}
		}
	}
	
	void manageCourses(){
		loop:while(true){
			println(sTitle
					+"1:Add Course\n"
					+"2:Delete Course\n"
					+"3:Edit Course\n"
					+"4:Back");
			switch(scanInt()){
			case 1:
				println("Please enter the courseID:");
				int courseID1 = scanInt();
				println("Please enter the courseName:");
				String name1 = scanString();
				println("Please enter the login name of teacher:");
				String teacherLoginName1 = scanString();
				println("Please enter the year:");
				int year1 = scanInt();
				
				if(ac.addCourse(courseID1, name1, teacherLoginName1, year1)){
					println("Success!");
				}else{
					println("Fail");
				}
				println();
				break;
			case 2:
				println("Please enter the courseID:");
				int courseID2 = scanInt();
				
				if(ac.deleteCourse(courseID2)){
					println("Success");
				}else{
					println("Fail");
				}
				println();
				break;
			case 3:
				println("Please enter the courseID:");
				int courseID3 = scanInt();
				
				Course course3 = ac.searchCourse(courseID3);
				if(course3 != null){
					println(course3.toItem());
					println();
					loop3:while(true){
						println(sTitle
								+"1:Edit Course Name\n"
								+"2:Edit Teacher\n"
								+"3:Edit Year\n"
								+"4:Back");
						switch(scanInt()){
						case 1:
							println("Please enter the new course name:");
							if(ac.editCourseName(course3, scanString())){
								println("Success!");
							}else{
								println("Fail");
							}
							break;
						case 2:
							println("Please enter the new teacher's login name:");
							if(ac.editCourseTeacher(course3, scanString())){
								println("Success!");
							}else{
								println("Fail");
							}
							break;
						case 3:
							println("Please enter the new year:");
							if(ac.editCourseYear(course3, scanInt())){
								println("Success!");
							}else{
								println("Fail");
							}
							break;
						case 4:
							ac.saveData();
							break loop3;
						default:
							println(generateErrTips(4));
						}
					}
				}else{
					println("The course does not exist");
				}
				break;
			case 4:
				ac.saveData();
				break loop;
			default:
				println(generateErrTips(4));
			}
		}
	}
	
	void manageTeachers(){
		loop:while(true){
			println("Please enter number to choose:\n"
					+"1:Search Teacher\n"
					+"2:Add Teacher\n"
					+"3:Edit Teacher's Info\n"
					+"4:Delete Teacher\n"
					+"5:Back");
			switch(scanInt()){
			case 1:
				println("Please enter the teacher's login name:");
				try {
					println(ac.searchTeacher(scanString()).toString());
				} catch (NullPointerException e) {
					println("There's no this teacher");
				}
				break;
			case 2:
				println("Please enter loginName:");
				String loginName1 = scanString();
				println("Please enter userName:");
				String userName = scanString();
				if(ac.addTeacher(loginName1, "123", userName)){
					println("Success!");
				}else{
					println("Fail");
				}
				break;
			case 3:
				println("Please enter the teacher's loginName");
				String loginName2 = scanString();
				loop3:while(true){
					println(sTitle
							+"1:Edit teacher's userName\n"
							+"2:Edit teacher's password\n"
							+"3:back");
					switch(scanInt()){
					case 1:
						println("Please enter the new username");
						ac.editTeacherName(loginName2, scanString());
						break;
					case 2:
						println("Please enter the new password");
						ac.editTeacherPassword(loginName2, scanString());
						break;
					case 3:
						ac.saveData();
						break loop3;
					default:
						println("Wrong input!Please enter a number between 1,2,3");
					}
				}
				break;
			case 4:
				println("Please enter the teacher's loginName");
				if(ac.deleteTeacher(scanString())){
					println("Success!");
				}else{
					println("Sorry!We can't find the teacher!");
				}
				break;
			case 5:
				ac.saveData();
				break loop;
			default:
				println(generateErrTips(5));
			}
		}
	}
	
	void manageStudents(){
		loop:while(true){
			println(sTitle
					+"1:Search Student\n"
					+"2:Add Graduate\n"
					+"3:Add Undergraduate\n"
					+"4:Edit Student's Info\n"
					+"5:Delete Student\n"
					+"6:Back");
			switch(scanInt()){
			case 1:
				println("Please enter the student's number:");
				try {
					println(ac.searchStudent(scanString()).toString());
				} catch (NullPointerException e) {
					println("There's no this student");
				}
				break;
			case 2:
				println("Please enter loginName:");
				String loginName = scanString();
				println("Please enter userName:");
				String userName = scanString();
				if(ac.addGraduate(loginName, "123", userName)){
					println("Success!");
				}else{
					println("Fail");
				}
				break;
			case 3:
				println("Please enter loginName:");
				String loginName2 = scanString();
				println("Please enter userName:");
				String userName2 = scanString();
				if(ac.addUndergraduate(loginName2, "123", userName2)){
					println("Success!");
				}else{
					println("Fail");
				}
				break;
			case 4:
				println("Please enter the student's login name");
				String loginName3 = scanString();
				loop3:while(true){
					println("Please enter number to choose:\n"
							+"1:Edit Student's UserName\n"
							+"2:Edit Student's Password\n"
							+"3:Back");
					switch(scanInt()){
					case 1:
						println("Please enter the new username");
						ac.editStudentName(loginName3, scanString());
						break;
					case 2:
						println("Please enter the new password");
						ac.editStudentPassword(loginName3, scanString());
						break;
					case 3:
						ac.saveData();
						break loop3;
					default:
						println(generateErrTips(3));
					}
				}
				break;
			case 5:
				println("Please enter the student's login name");
				String loginName4 = scanString();
				if(!ac.deleteStudent(loginName4)){
					println("Sorry!We can't find the student!");
				}
				break;
			case 6:
				ac.saveData();
				break loop;
			default:
				println(generateErrTips(6));
			}
		}
	}

	void editPersonalInfo(){
		loop:while(true){
			println("Do you want to edit user name or password?\n"
					+"1:User Name\n"
					+"2:Password\n"
					+"3:Neither");
			switch(scanInt()){
			case 1:
				println("Please enter the new user name:");
				//!!!!!!!!!!!!应该检查是否有效的!!!!!!!!!!!!!!
				ac.editAdminName(scanString());
				println("Success!");
				break;
			case 2:
				println("Please enter the new password:");
				//!!!!!!!!!!!!!应该验证旧密码！！！！！！！！
				ac.editAdminPassword(scanString());
				println("Success!");
				break;
			case 3:
				ac.saveData();
				break loop;
			default:
				println(generateErrTips(3));
			}
		}
	}
}