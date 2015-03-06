package edu.software.scoremanage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * ������Teacher
 * ���������û���һ������
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
    
    /* ���ڸ�����Ϣ�ķ����������޸����ֺ�����*/
	public void editUserName(String newName){
		userName = newName;
	}
	public void editPassword(String newPassword){
		password = newPassword;
	}
	
	/* ���ڿγ̵ķ�����������ɾ�γ̣�������*/
	public void addCourse(Course course){
		courses.add(course);
	}
	public void deleteCourse(Course course){
		courses.remove(course);
	}
	public List<Course> getCourses(){
		return courses;
	}
	
	/*  ���ڳɼ��˲�����ķ���������ɾ��*/
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
	
	/* ����ѧ���ķ���*/
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
