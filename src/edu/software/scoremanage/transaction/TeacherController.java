package edu.software.scoremanage.transaction;

import java.util.List;
import edu.software.scoremanage.model.Course;
import edu.software.scoremanage.model.Curriculum;
import edu.software.scoremanage.model.Request;
import edu.software.scoremanage.model.SignUpCourse;
import edu.software.scoremanage.model.Student;
import edu.software.scoremanage.model.Teacher;
import edu.software.scoremanage.model.User;
import edu.software.scoremanage.util.DataHelper;

public class TeacherController {
	Curriculum curriculum = Curriculum.getInstance();
	User user = User.getInstance();
	Teacher teacher;
	
	public TeacherController(Teacher teacher){
		this.teacher = teacher;
	}
	
	/* ���������½��Ϣ�ķ���*/
	public void editUserName(String newName){
		teacher.editUserName(newName);
	}
	public void editPassword(String newPassword){
		teacher.editPassword(newPassword);
	}
	
	/* ���ڳɼ��˲�����ķ���*/
	public List<Request> getRequests(){
		return teacher.getRequests();
	}
	public void answerRequest(Request request,boolean decision){
		teacher.deleteRequest(request);
		request.editStatus(decision);
	}
	
	/* ����ѧ���ķ���*/
	public boolean addStudent(String loginName,Course course){
		Student student = user.searchStudent(loginName);
		if(student != null){
			return curriculum.addSignUpCourse(student, course);
		}
		return false;
	}
	public boolean deleteStudent(String loginName,Course course){
		Student student = user.searchStudent(loginName);
		if(student != null){
			return curriculum.deleteSignUpCourse(student, course);
		}
		return false;
	}
	
	/* ����SignUpCourse�ķ���*/
	public List<SignUpCourse> getSUC(Course course){
		return course.SUCList;
	}
	public SignUpCourse getSUCOfStudent(Course course,String loginName){
		for(SignUpCourse suc:course.SUCList){
			if(loginName.equals(suc.student.loginName)){
				return suc;
			}
		}
		return null;
	}
	
	/* ���ڳɼ��ķ���*/
	public void editScore(SignUpCourse suc,float score){
		curriculum.editScore(suc, score);
	}
	
	/*  ����course�ķ���*/
	public List<Course> getCourses(){
		return teacher.getCourses();
	}
	
	public void saveData(){
		DataHelper.saveData();
	}

}
