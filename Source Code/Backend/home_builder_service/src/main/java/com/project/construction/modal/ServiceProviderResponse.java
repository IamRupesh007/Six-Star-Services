package com.project.construction.modal;

import java.util.HashSet;
import java.util.Set;

import com.project.construction.entity.EndUser;
import com.project.construction.entity.Role;
import com.project.construction.entity.ServiceProvider;
import com.project.construction.entity.ServiceRequest;
import com.project.construction.entity.ServiceType;

public class ServiceProviderResponse implements Comparable<ServiceProviderResponse> {
	
	public ServiceProviderResponse() {
		super();
	}
	@Override
	public int compareTo(ServiceProviderResponse e) {
		int hash = this.serviceProviderName.compareTo(e.serviceProviderName);
		if(hash==0) {
			if(this.id>e.id) {
				return 1;
			}
			if(this.id<e.id) {
				return -1;
			}
			return 0;
		}
		return hash;
	}
	
	private Integer id;

	private String serviceProviderName;

	private Set<ServiceType> serviceTypes;

	private Set<ServiceRequestModal> serviceRequests = new HashSet<>();

	private Integer userId;

	private String firstName;

	private String middleName;

	private String lastName;

	private String phoneNumber;

	private String email;

	private String addressLine1;

	private String addressLine2;

	private String city;

	private String state;

	private Role role;

	public ServiceProviderResponse(Integer id, String serviceProviderName, Set<ServiceType> serviceTypes,
			Set<ServiceRequestModal> serviceRequests, Integer userId, String firstName, String middleName,
			String lastName, String phoneNumber, String email, String addressLine1, String addressLine2, String city,
			String state, Role role) {
		super();
		this.id = id;
		this.serviceProviderName = serviceProviderName;
		this.serviceTypes = serviceTypes;
		this.serviceRequests = serviceRequests;
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.role = role;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public static ServiceProviderResponse getResponseFromEntity(ServiceProvider serviceProvider) {
		EndUser user = serviceProvider.getUser();
		Set<ServiceRequestModal> serviceRequests = new HashSet<>();
		for (ServiceRequest sR : serviceProvider.getServiceRequests()) {
			ServiceRequestModal s = ServiceRequestModal.getModalFromEntity(sR);
			serviceRequests.add(s);
		}
		ServiceProviderResponse res = new ServiceProviderResponse(serviceProvider.getId(),
				serviceProvider.getServiceProviderName(), serviceProvider.getServiceTypes(), serviceRequests, user.getId(),user.getFirstName(), user.getMiddleName(),
				user.getLastName(), user.getPhoneNumber(), user.getEmail(),
				user.getAddressLine1(), user.getAddressLine2(), user.getCity(),
				user.getState(), user.getRole());
		return res;
	}
}
