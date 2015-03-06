package edu.software.scoremanage.model;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * 类名：User
 * 类描述：User类用于表示用户的集合
 * 注意：所有计数底层从0开始，输入从1开始
 * @author:Sissel
 * @version:2015-02-18 16:49:46
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//3 kinds of users.
	//Only one administrator;
	//The number of students and teachers are defined by the arguments above;
	ArrayList<Teacher> teachers;
	ArrayList<Student> students;
	Administrator administrator;
	
	private static User user;
	
	private User(){
		teachers = new ArrayList<Teacher>();
		students = new ArrayList<Student>();
		administrator = new Administrator("Admin","Admin","Admin");
	}
	
	/* 最开始的时候，未有数据时，由DataHelper调用*/
	public static void initialize(){
		user = new User();
	}
	/* 从数据恢复的时候，由DataHelper调用*/
	public static void recover(User recovery){
		user = recovery;
	}
	public static User getInstance(){
		return user;
	}
	
	public Teacher searchTeacher(String loginName){
		for(Teacher t:teachers){
			if(t.loginName.equals(loginName)){
				return t;
			}
		}
		return null;
	}
	public Student searchStudent(String loginName){
		for(Student s:students){
			if(s.loginName.equals(loginName)){
				return s;
			}
		}
		return null;
	}
	/* 删除用户*/
	public boolean deleteTeacher(String loginName){
		for(Teacher t:teachers){
			if(t.loginName.equals(loginName)){
				teachers.remove(t);
				return true;
			}
		}
		return false;
	}
	public boolean deleteStudent(String loginName){
		for(Student s:students){
			if(s.loginName.equals(loginName)){
				students.remove(s);
				return true;
			}
		}
		return false;
	}
	/* 增加用户*/
	public boolean addGraduate(String loginName,String userName,String password){
		for(Student s:students){
			if(s.loginName.equals(loginName)){
				return false;
			}
		}
		students.add(new Graduate(loginName,password,userName));
		return true;
	}
	public boolean addUndergraduate(String loginName,String userName,String password){
		for(Student s:students){
			if(s.loginName.equals(loginName)){
				return false;
			}
		}
		students.add(new Undergraduate(loginName,password,userName));
		return true;
	}
	public boolean addTeacher(String loginName,String userName,String password){
		for(Teacher t:teachers){
			if(t.loginName.equals(loginName)){
				return false;
			}
		}
		teachers.add(new Teacher(loginName,password,userName));
		return true;
	}
	
	/* 修改用户信息*/
	// 学生
	public boolean editStudentName(String loginName,String newName){
		for(Student s:students){
			if(s.loginName.equals(loginName)){
				s.editUserName(newName);
				return true;
			}
		}
		return false;
	}
	public boolean editStudentPassword(String loginName,String newPassword){
		for(Student s:students){
			if(s.loginName.equals(loginName)){
				s.editPassword(newPassword);
				return true;
			}
		}
		return false;
	}
	// 教师
	public boolean editTeacherName(String loginName,String newName){
		for(Teacher t:teachers){
			if(t.loginName.equals(loginName)){
				t.editUserName(newName);
				return true;
			}
		}
		return false;
	}
	public boolean editTeacherPassword(String loginName,String newPassword){
		for(Teacher t:teachers){
			if(t.loginName.equals(loginName)){
				t.editPassword(newPassword);
				return true;
			}
		}
		return false;
	}
	// 管理员
	public void editAdminName(String newName){
		administrator.editUserName(newName);
	}
	public void editAdminPassword(String newPassword){
		administrator.editPassword(newPassword);
	}
	
	/* 登陆验证功能*/
	public boolean verifyAdmin(String loginName,String password){
		if(loginName.equals(administrator.loginName) && password.equals(administrator.password)){
			return true;
		}
		return false;
	}
	public boolean verifyStudent(String loginName,String password){
		for(Student s:students){
			if(loginName.equals(s.loginName) && password.equals(s.password)){
				return true;
			}
		}
		return false;
	}
	public boolean verifyTeacher(String loginName,String password){
		for(Teacher t:teachers){
			if(loginName.equals(t.loginName) && password.equals(t.password)){
				return true;
			}
		}
		return false;
	}
}
