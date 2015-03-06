package edu.software.scoremanage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 类名：Student
 * 类描述：用户的一种类型
 * @author:Sissel
 * @version:2015-02-17 16:05:30
 */
public abstract class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//Both loginName,passWord,userName can consist of numbers and letters
	public String loginName;
	String password;
	public String userName;
	ArrayList<SignUpCourse> SUCList;
	ArrayList<Request> requests;
	
    public Student(String loginName,String password,String userName){
		this.loginName = loginName;
		this.password = password;
		this.userName = userName;
		SUCList = new ArrayList<SignUpCourse>();
		requests = new ArrayList<Request>();
	}
	
    /* 关于个人信息的方法，包括修改名字和密码*/
	public void editUserName(String newName){
		userName = newName;
	}
	public void editPassword(String newPassword){
		password = newPassword;
	}
	
	/* 关于选课的方法，包括添加删除选课记录，返回选课列表*/
	public void addSignUpCourse(SignUpCourse suc){
		SUCList.add(suc);
	}
	public void deleteSignUpCourse(SignUpCourse suc){
		SUCList.remove(suc);
	}
	public ArrayList<SignUpCourse> getScores(){
		return SUCList;
	}
	
	/* 关于成绩的方法，包括平均分，成绩分布，返回特定课程成绩*/
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
	// 正确查找返回成绩，否则返回-1
	public float getScoreOfCourse(Course course){
		for(SignUpCourse suc:SUCList){
			if(suc.course.equals(course)){
				return suc.getScore();
			}
		}
		return -1;
	}

	/* 关于请求核查成绩的方法，包括申请及查询*/
	public abstract void applyRequest(Request request);
	public abstract List<Request> checkRequest();
	
	@Override
	public boolean equals(Object o){
		return this.loginName.equals(((Student)o).loginName);
	}
	
	@Override
	public String toString(){
		return "Login name:"+loginName+" User name:"+userName;
	}

}
