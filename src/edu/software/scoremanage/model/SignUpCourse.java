package edu.software.scoremanage.model;

import java.io.Serializable;

import edu.software.scoremanage.util.StringItem;

public class SignUpCourse implements Serializable,StringItem{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Course course;
	public Student student;
	private float score;
	public SignUpCourse(Course course,Student student,float score){
		this.course = course;
		this.student = student;
		this.score = score;
	}
	
	float getScore(){
		return score;
	}
	
	void editScore(float score){
		this.score = score;
	}
	
	@Override
	public String toItem(){
		return course.toItem()+" "+student.userName+" "+score;
	}
}
