package com.project.construction.modal;

import java.util.Set;

public class AllUserModal {
	
	public Set<ServiceProviderResponse> serviceProviders;
	
	public Set<EndUserModal> customers;
	
	public Set<EndUserModal> admins;
	
	public Set<ServiceRequestModal> serviceRequests;

	public AllUserModal(Set<ServiceProviderResponse> serviceProviders, Set<EndUserModal> customers,
			Set<EndUserModal> admins,Set<ServiceRequestModal> serviceRequests) {
		super();
		this.serviceProviders = serviceProviders;
		this.customers = customers;
		this.admins = admins;
		this.serviceRequests = serviceRequests;
	}
	public AllUserModal() {};

	public Set<ServiceProviderResponse> getServiceProviders() {
		return serviceProviders;
	}

	public void setServiceProviders(Set<ServiceProviderResponse> serviceProviders) {
		this.serviceProviders = serviceProviders;
	}

	public Set<EndUserModal> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<EndUserModal> customers) {
		this.customers = customers;
	}

	public Set<EndUserModal> getAdmins() {
		return admins;
	}

	public void setAdmins(Set<EndUserModal> admins) {
		this.admins = admins;
	}

	public Set<ServiceRequestModal> getServiceRequests() {
		return serviceRequests;
	}

	public void setServiceRequests(Set<ServiceRequestModal> serviceRequests) {
		this.serviceRequests = serviceRequests;
	}
	
	
}
