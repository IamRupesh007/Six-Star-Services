package com.project.construction.modal;

public class ServiceProviderData {
	public ServiceProviderData() {
		super();
	}

	private ServiceProviderModal serviceProvider;
	private EndUserModal user;
	private String password;

	public ServiceProviderData(ServiceProviderModal serviceProvider, EndUserModal user, String password) {
		super();
		this.serviceProvider = serviceProvider;
		this.user = user;
		this.password = password;
	}

	public ServiceProviderModal getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProviderModal serviceProvider) {
		this.serviceProvider = serviceProvider;
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
