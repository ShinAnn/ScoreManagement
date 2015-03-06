package edu.software.scoremanage.model;

import java.io.Serializable;

import edu.software.scoremanage.util.StringItem;

public class Request implements Serializable,StringItem{
	
	private static final long serialVersionUID = 1L;
	String reason;
	SignUpCourse suc;
	boolean status;
	
	public Request(String reason,SignUpCourse suc){
		this.reason = reason;
		this.suc = suc;
		status = false;
	}
	
	public String getReason(){
		return reason;
	}
	
	public SignUpCourse getSUC(){
		return suc;
	}
	
	public boolean getStatus(){
		return status;
	}
	
	public void editStatus(boolean decision){
		status = decision;
	}
	
	@Override
	public String toString(){
		String s = "Student:"+suc.student.userName
				+" Course:"+suc.course.name
				+" Score:"+suc.getScore()
				+" Status:";
		if(status){
			s += "handled\n";
		}else{
			s += "unhandled\n";
		}
		s += reason;
		return s;
	}
	@Override
	public String toItem(){
		String s = "Student:"+suc.student.userName
				+" Course:"+suc.course.name
				+" Score:"+suc.getScore()
				+" Status:";
		if(status){
			s += "handled";
		}else{
			s += "unhandled";
		}
		return s;
	}

}
