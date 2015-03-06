package edu.software.scoremanage.model;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * ������User
 * ��������User�����ڱ�ʾ�û��ļ���
 * ע�⣺���м����ײ��0��ʼ�������1��ʼ
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
	
	/* �ʼ��ʱ��δ������ʱ����DataHelper����*/
	public static void initialize(){
		user = new User();
	}
	/* �����ݻָ���ʱ����DataHelper����*/
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
	/* ɾ���û�*/
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
	/* �����û�*/
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
	
	/* �޸��û���Ϣ*/
	// ѧ��
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
	// ��ʦ
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
	// ����Ա
	public void editAdminName(String newName){
		administrator.editUserName(newName);
	}
	public void editAdminPassword(String newPassword){
		administrator.editPassword(newPassword);
	}
	
	/* ��½��֤����*/
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
