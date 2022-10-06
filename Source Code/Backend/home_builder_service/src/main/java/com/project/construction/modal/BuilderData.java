package com.project.construction.modal;



public class BuilderData {
	
	public BuilderData() {};

	private BuilderModal builder;
	private EndUserModal user;

	public BuilderData(BuilderModal builder, EndUserModal user) {
		super();
		this.builder = builder;
		this.user = user;
	}

	public BuilderModal getBuilder() {
		return builder;
	}

	public void setBuilder(BuilderModal builder) {
		this.builder = builder;
	}

	public EndUserModal getUser() {
		return user;
	}

	public void setUser(EndUserModal user) {
		this.user = user;
	}
	
	
	
	
}
