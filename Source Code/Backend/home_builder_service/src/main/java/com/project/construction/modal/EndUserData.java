package com.project.construction.modal;


public class EndUserData {

	private EndUserModal user;
	private String password;
	
	public EndUserData() {
		super();
	}

	public EndUserData(EndUserModal user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	public EndUserModal getUser() {
		return user;
	}

	public void setUser(EndUserModal user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
