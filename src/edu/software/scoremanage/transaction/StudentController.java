package edu.software.scoremanage.transaction;

import java.util.List;
import java.util.Map;

import edu.software.scoremanage.model.Course;
import edu.software.scoremanage.model.Curriculum;
import edu.software.scoremanage.model.Request;
import edu.software.scoremanage.model.SignUpCourse;
import edu.software.scoremanage.model.Student;
import edu.software.scoremanage.model.User;
import edu.software.scoremanage.util.DataHelper;

public class StudentController {
	Curriculum curriculum = Curriculum.getInstance();
	User user = User.getInstance();
	Student student;
	
	public StudentController(Student student){
		this.student = student;
	}
	
	/* 关于自身登陆信息的方法*/
	public void editUserName(String newName){
		student.editUserName(newName);
	}
	public void editPassword(String newPassword){
		student.editPassword(newPassword);
	}
	
	/* 关于成绩的方法*/
	public List<SignUpCourse> getScores(){
		return student.getScores();
	}
	public float getAverageScore(){
		return student.getAverageScore();
	}
	public Map<String,Integer> getStatistics(){
		return student.getStatistics();
	}
	public float getScoreOfCourse(Course course){
		return student.getScoreOfCourse(course);
	}
	
	/* 关于核查成绩的方法*/
	public boolean applyRequest(int courseID,String reason){
		Course course = curriculum.searchCourse(courseID);
		SignUpCourse suc;
		if(course == null){
			return false;
		}else{
			suc = curriculum.searchSignUpCourse(student, course);
			if(suc == null){
				return false;
			}else{
				Request request = new Request(reason,suc);
				course.teacher.addRequest(request);
				student.applyRequest(request);
				return true;
			}
		}
	}
	public List<Request> checkRequest(){
		return student.checkRequest();
	}

	public Request searchRequest(int courseID){
		for(Request rq:student.checkRequest()){
			if(rq.getSUC().course.courseID == courseID){
				return rq;
			}
		}
		return null;
	}
	public void saveData(){
		DataHelper.saveData();
	}
}
