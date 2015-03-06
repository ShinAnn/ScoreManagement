package edu.software.scoremanage.model;

import java.util.ArrayList;

public class Graduate extends Student{
	
	private static final long serialVersionUID = 1L;

	public Graduate(String loginName, String password, String userName) {
		super(loginName, password, userName);
	}

	@Override
	public void applyRequest(Request request) {
		this.requests.add(request);
		return;
	}

	@Override
	public ArrayList<Request> checkRequest() {
		return this.requests;
	}
}
