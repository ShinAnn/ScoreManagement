package edu.software.scoremanage.userinterface;

import java.util.List;
import java.util.Map;

import edu.software.scoremanage.model.Course;
import edu.software.scoremanage.model.Request;
import edu.software.scoremanage.model.SignUpCourse;
import edu.software.scoremanage.model.Teacher;
import edu.software.scoremanage.transaction.TeacherController;
import static edu.software.scoremanage.util.GenerateCode.*;
import static edu.software.scoremanage.util.MyIO.*;

public class TeacherUI {
	
	TeacherController tc;
	
	public TeacherUI(Teacher t){
		tc = new TeacherController(t);
	}
	
	public void mainMenu(){
		loop:while(true){
			println("Please enter number to choose:\n"
					+"1:Dule with Requests\n"
					+"2:Manage Students\n"
					+"3:Manage Scores\n"
					+"4:Edit Personal Info\n"
					+"5:Log Out");
			switch(scanInt()){
			case 1:
				this.duleWithRequest();
				break;
			case 2:
				this.manageStudentsEntrance();
				break;
			case 3:
				this.manageScoresEntrance();
				break;
			case 4:
				this.editPersonalInfo();
				break;
			case 5:
				tc.saveData();
				break loop;
			default:
				println("Wrong input.Please choose a number between 1,2,3,4,5");
			}
		}
	}
	
	void duleWithRequest(){
		
		List<Request> rqs= tc.getRequests();
		String selections = "Please enter number to choose:\n"
				+generateListFromSI(rqs)
				+(rqs.size()+1)+":Back";
		
		loop:while(true){
			println(selections);
			int choice = scanInt();
			if(rqs.size()+1 == choice){
				break loop;
			}else if(0 < choice && choice <= rqs.size()){
				this.requestDetail(rqs.get(choice-1));
				//！！！！！！！！！粗暴的刷新方法
				this.duleWithRequest();
				break loop;
			}else{
				println("Wrong input.Please choose a rational number");
			}
		}
	}
	void requestDetail(Request request){
		println(request.toString());
		println();
		loop:while(true){
			println("Please enter number to choose:\n"
					+"1:Mark it Handled\n"
					+"2:Back");
			switch(scanInt()){
			case 1:
				tc.answerRequest(request, true);
				tc.saveData();
				break loop;
			case 2:
				break loop;
			default:
				println("Wrong input.Please choose a number between 1,2");
			}
		}
	}
	
	void manageStudentsEntrance(){
		List<Course> courses = tc.getCourses();
		String selections = "Please enter number to choose:\n"
				+generateListFromSI(courses)
				+(courses.size()+1)+":Back";
		
		loop:while(true){
			println(selections);
			int choice = scanInt();
			if(courses.size()+1 == choice){
				break loop;
			}else if(0 < choice && choice <= courses.size()){
				this.manageStudents(courses.get(choice-1));
				break loop;
			}else{
				println("Wrong input.Please choose a rational number");
			}
		}
	}
	void manageStudents(Course course){
		loop:while(true){
			println("Please enter number to choose:\n"
					+"1:List all Students\n"
					+"2:Search Student\n"
					+"3:Add Student\n"
					+"4:Delete Student\n"
					+"5:Back");
			switch(scanInt()){
			case 1:
				print(generateListFromSI(tc.getSUC(course)));
				println();
				break;
			case 2:
				println("Please enter the login name of the student");
				String login2 = scanString();
				SignUpCourse suc = tc.getSUCOfStudent(course, login2);
				if(suc != null){
					println(suc.toItem());
				}else{
					println("The student is not in this course");
				}
				println();
				break;
			case 3:
				println("Please enter the login name of the student");
				String login3 = scanString();
				if(tc.addStudent(login3, course)){
					println("Success!");
				}else{
					println("The student is either not existed or already in this course");
				}
				println();
				break;
			case 4:
				println("Please enter the login name of the student");
				String login4 = scanString();
				if(tc.deleteStudent(login4, course)){
					println("Success!");
				}else{
					println("The student is not in this course");
				}
				println();
				break;
			case 5:
				tc.saveData();
				break loop;
			default:
				println("Wrong input.Please choose a number between 1,2,3,4,5");
			}
		}
	}
	
	void manageScoresEntrance(){
		List<Course> courses = tc.getCourses();
		String selections = "Please enter number to choose:\n"
				+generateListFromSI(courses)
				+(courses.size()+1)+":Back";
		
		loop:while(true){
			println(selections);
			int choice = scanInt();
			if(courses.size()+1 == choice){
				break loop;
			}else if(0 < choice && choice <= courses.size()){
				this.manageScores(courses.get(choice-1));
				break loop;
			}else{
				println("Wrong input.Please choose a rational number");
			}
		}
	}
	void manageScores(Course course){
		List<SignUpCourse> sucs= tc.getSUC(course);
		loop:while(true){
			println("Please enter number to choose:\n"
					+"1:List all Scores\n"
					+"2:Check Average Score\n"
					+"3:Check Scores Distribution\n"
					+"4:Edit Student's Score\n"
					+"5:Back");
			switch(scanInt()){
			case 1:
				println(generateListFromSI(sucs));
				println();
				break;
			case 2:
				println("The average score is "+course.getAverageScore());
				println();
				break;
			case 3:
				Map<String,Integer> map = course.getStatistics();
				println(generateList(map));
				println();
				break;
			case 4:
				println("Please enter the login name of the student:");
				String login4 = scanString();
				SignUpCourse suc = tc.getSUCOfStudent(course, login4);
				if(suc != null){
					println(suc.toItem());
					println("Please enter the new score:");
					float score = scanFloat();
					tc.editScore(suc, score);
				}else{
					println("The student is not in this course");
				}
				println();
				break;
			case 5:
				tc.saveData();
				break loop;
			default:
				println("Wrong input.Please choose a number between 1,2,3,4,5");
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
				tc.editUserName(scanString());
				println("Success!");
				break;
			case 2:
				println("Please enter the new password:");
				//!!!!!!!!!!!!!应该验证旧密码！！！！！！！！
				tc.editPassword(scanString());
				println("Success!");
				break;
			case 3:
				tc.saveData();
				break loop;
			default:
				println("Wrong input!Please enter a number between 1,2,3");
			}
		}
	}

}