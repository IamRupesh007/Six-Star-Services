package com.project.construction.modal;

import java.util.HashSet;
import java.util.Set;

import com.project.construction.entity.ServiceProvider;
import com.project.construction.entity.ServiceRequest;
import com.project.construction.entity.ServiceType;

public class ServiceProviderModal {
	
	public ServiceProviderModal() {
		super();
	}

	private Integer id;

	private String serviceProviderName;

	private EndUserModal user;

	private Set<ServiceType> serviceTypes;

	private Set<ServiceRequestModal> serviceRequests = new HashSet<>();

	public ServiceProviderModal(Integer id, String serviceProviderName, EndUserModal user,
			Set<ServiceType> serviceTypes, Set<ServiceRequestModal> serviceRequests) {
		super();
		this.id = id;
		this.serviceProviderName = serviceProviderName;
		this.user = user;
		this.serviceTypes = serviceTypes;
		this.serviceRequests = serviceRequests;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServiceProviderName() {
		return serviceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}

	public EndUserModal getUser() {
		return user;
	}

	public void setUser(EndUserModal user) {
		this.user = user;
	}

	public Set<ServiceType> getServiceTypes() {
		return serviceTypes;
	}

	public void setServiceTypes(Set<ServiceType> serviceTypes) {
		this.serviceTypes = serviceTypes;
	}

	public Set<ServiceRequestModal> getServiceRequests() {
		return serviceRequests;
	}

	public void setServiceRequests(Set<ServiceRequestModal> serviceRequests) {
		this.serviceRequests = serviceRequests;
	}

	public static ServiceProviderModal getModalFromEntity(ServiceProvider serviceProvider) {
		EndUserModal user = EndUserModal.getModalFromEntity(serviceProvider.getUser());
		Set<ServiceRequestModal> serviceRequests = new HashSet<>();
		for (ServiceRequest sR : serviceProvider.getServiceRequests()) {
			ServiceRequestModal s = ServiceRequestModal.getModalFromEntity(sR);
			serviceRequests.add(s);
		}
		return new ServiceProviderModal(serviceProvider.getId(), serviceProvider.getServiceProviderName(), user,
				serviceProvider.getServiceTypes(), serviceRequests);
	}

	public static ServiceProvider getEntityFromModal(ServiceProviderModal serviceProviderModal) {

		return new ServiceProvider(serviceProviderModal.getId(), serviceProviderModal.getServiceProviderName(), null,
				serviceProviderModal.getServiceTypes(), new HashSet<>());
	}

}
