package edu.software.scoremanage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * 类名：Teacher
 * 类描述：用户的一种类型
 * @author:Sissel
 * @version:2015-02-17 16:04:04
 */
public class Teacher implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//Both loginName,passWord,userName can consist of numbers and letters
	String loginName;
	String password;
	String userName;
	ArrayList<Request> requests;
	ArrayList<Course> courses;
	
    Teacher(String loginName,String password,String userName){
		this.loginName = loginName;
		this.password = password;
		this.userName = userName;
		requests = new ArrayList<Request>();
		courses = new ArrayList<Course>();
	}
    
    /* 关于个人信息的方法，包括修改名字和密码*/
	public void editUserName(String newName){
		userName = newName;
	}
	public void editPassword(String newPassword){
		password = newPassword;
	}
	
	/* 关于课程的方法，包括增删课程（对自身）*/
	public void addCourse(Course course){
		courses.add(course);
	}
	public void deleteCourse(Course course){
		courses.remove(course);
	}
	public List<Course> getCourses(){
		return courses;
	}
	
	/*  关于成绩核查申请的方法，包括删除*/
	public void addRequest(Request request){
		requests.add(request);
		return;
	}
	public void deleteRequest(Request request){
		requests.remove(request);
	}
	public List<Request> getRequests(){
		return this.requests;
	}
	
	/* 关于学生的方法*/
	public List<Student> getStudents(Course course){
		ArrayList<Student> slist = new ArrayList<Student>();
		for(SignUpCourse suc:course.SUCList){
			slist.add(suc.student);
		}
		return slist;
	}
	
	@Override
	public String toString(){
		return "Login name:"+loginName+" User name:"+userName;
	}
}
