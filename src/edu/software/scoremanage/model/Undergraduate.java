package edu.software.scoremanage.model;

import java.util.List;

public class Undergraduate extends Student{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Undergraduate(String loginName, String password, String userName) {
		super(loginName, password, userName);
	}

	@Override
	public void applyRequest(Request request) {
		this.requests.add(request);
		return;
	}

	@Override
	public List<Request> checkRequest() {
		return this.requests;
	}

}
