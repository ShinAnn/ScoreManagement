package edu.software.scoremanage.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Curriculum implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public static Curriculum curriculum;
	
	private ArrayList<Course> courseList;
	private ArrayList<SignUpCourse> SUCList;
	
	private Curriculum(){
		this.courseList = new ArrayList<Course>();
		this.SUCList = new ArrayList<SignUpCourse>();
	}
	public static Curriculum getInstance(){
		return curriculum;
	}
	
	public static void initialize(){
		curriculum = new Curriculum();
	}
	public static void recover(Curriculum recovery){
		curriculum = recovery;
	}
	
	/* SignUpCourse��ط���*/
	// ���ң������ڷ���false
	public SignUpCourse searchSignUpCourse(Student student,Course course){
		for(SignUpCourse suc:SUCList){
			if(suc.student.equals(student) && suc.course.equals(course)){
				return suc;
			}
		}
		return null;
	}
	// ��ӣ���ȷ��ӷ���true��������ͬSUC����false
	public boolean addSignUpCourse(Student student,Course course){
		if(this.searchSignUpCourse(student, course) != null){
			return false;
		}
		SignUpCourse nsuc = new SignUpCourse(course,student,0);
		SUCList.add(nsuc);
		student.addSignUpCourse(nsuc);
		course.addSignUpCourse(nsuc);
		return true;
	}
	// ɾ������ȷɾ������true���޷��ҵ����󷵻�false
	public boolean deleteSignUpCourse(Student student,Course course){
		SignUpCourse suc = this.searchSignUpCourse(student, course);
		if( suc != null){
			student.deleteSignUpCourse(suc);
			course.deleteSignUpCourse(suc);
			SUCList.remove(suc);
			return true;
		}
		return false;
	}
	// �޸ģ�ֻ�ܸĳɼ�
	public void editScore(SignUpCourse suc,float score){
		suc.editScore(score);
	}
	
	/* Course��ط���*/
	// ���ң������ڷ���false
	public Course searchCourse(int courseID){
		for(Course c:courseList){
			if(c.courseID == courseID){
				return c;
			}
		}
		return null;
	}
	public boolean addCourse(int courseID,String name,Teacher teacher,int year){
		if(this.searchCourse(courseID)== null ){
			Course newCourse = new Course(courseID,name,teacher,year);
			courseList.add(newCourse);
			teacher.addCourse(newCourse);
			return true;
		}
		return false;
	}
	public boolean deleteCourse(int courseID){
		Course c = this.searchCourse(courseID);
		if(c != null){
			c.teacher.deleteCourse(c);
			courseList.remove(c);
			return true;
		}
		return false;
	}
    public boolean editCourseName(Course course,String newName){
		course.editName(newName);
		return true;
	}
    public boolean editCourseTeacher(Course course,Teacher teacher){
    	course.teacher.deleteCourse(course);
    	course.editTeacher(teacher);
    	teacher.addCourse(course);
		return true;
	}
    public boolean editCourseYear(Course course,int year){
		course.editYear(year);
		return true;
	}
    
}
