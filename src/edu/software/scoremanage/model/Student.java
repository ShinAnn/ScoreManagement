package edu.software.scoremanage.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * ������Student
 * ���������û���һ������
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
	
    /* ���ڸ�����Ϣ�ķ����������޸����ֺ�����*/
	public void editUserName(String newName){
		userName = newName;
	}
	public void editPassword(String newPassword){
		password = newPassword;
	}
	
	/* ����ѡ�εķ������������ɾ��ѡ�μ�¼������ѡ���б�*/
	public void addSignUpCourse(SignUpCourse suc){
		SUCList.add(suc);
	}
	public void deleteSignUpCourse(SignUpCourse suc){
		SUCList.remove(suc);
	}
	public ArrayList<SignUpCourse> getScores(){
		return SUCList;
	}
	
	/* ���ڳɼ��ķ���������ƽ���֣��ɼ��ֲ��������ض��γ̳ɼ�*/
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
	// ��ȷ���ҷ��سɼ������򷵻�-1
	public float getScoreOfCourse(Course course){
		for(SignUpCourse suc:SUCList){
			if(suc.course.equals(course)){
				return suc.getScore();
			}
		}
		return -1;
	}

	/* ��������˲�ɼ��ķ������������뼰��ѯ*/
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
