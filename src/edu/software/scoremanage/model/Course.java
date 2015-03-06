package edu.software.scoremanage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.software.scoremanage.util.StringItem;

public class Course implements Serializable,StringItem {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int courseID;
	public String name;
	public Teacher teacher;
	public int year;
	public ArrayList<SignUpCourse> SUCList;
	
	public Course(int courseID,String name,Teacher teacher,int year){
		this.courseID = courseID;
		this.name = name;
		this.teacher = teacher;
		this.year = year;
		SUCList = new ArrayList<SignUpCourse>();
	}
	
	/* 关于课程信息的方法，包括修改教师和年份*/
	void editTeacher(Teacher newTeacher){
		this.teacher = newTeacher;
	}
	void editYear(int newYear){
		this.year = newYear;
	}
	void editName(String newName){
		this.name = newName;
	}
	
	/* 关于选课的方法，包括增删选课*/
	void addSignUpCourse(SignUpCourse suc){
		SUCList.add(suc);
	}
	void deleteSignUpCourse(SignUpCourse suc){
		SUCList.remove(suc);
	}
	ArrayList<SignUpCourse> getScores(){
		return SUCList;
	}
	
	/* 关于成绩的方法，包括平均分，成绩分布*/
	public float getAverageScore(){
		float total = 0;
		for(SignUpCourse suc:SUCList){
			total += suc.getScore();
		}
	    return total/SUCList.size();
	}
	public Map<String,Integer> getStatistics(){
		Map<String,Integer> map = new HashMap<String,Integer>();
		int a=0,b=0,c=0,d=0;
		for(SignUpCourse suc:SUCList){
			float score = suc.getScore();
			if(score >= 90){
				a++;
			}else if(score >= 75){
				b++;
			}else if(score >= 60){
				c++;
			}else{
				d++;
			}
		}
		map.put("A", a);
		map.put("B", b);
		map.put("C", c);
		map.put("D", d);
		return map;
	}
	
	@Override
	public boolean equals(Object o){
		return this.courseID == ((Course)o).courseID;
	}
	@Override
	public String toItem(){
		return this.courseID+" "+this.name+" "+this.teacher.userName+" "+year;
	}
}
