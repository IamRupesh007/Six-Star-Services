package com.project.construction.modal;

import java.util.HashSet;
import java.util.Set;

import com.project.construction.entity.BuilderRequest;
import com.project.construction.entity.EndUser;
import com.project.construction.entity.Role;
import com.project.construction.entity.ServiceRequest;

public class EndUserModal implements Comparable<EndUserModal>  {
	
	public EndUserModal() {
		super();
	}

	@Override
	public int compareTo(EndUserModal e) {
		int hash = this.firstName.compareTo(e.firstName);
		if(hash==0) {
			if(hash==0) {
				if(this.id>e.id) {
					return 1;
				}
				if(this.id<e.id) {
					return -1;
				}
				return 0;
			}
		}
		return hash;
	}

	private Integer id;

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

	private Set<ServiceRequestModal> serviceRequests = new HashSet<>();

	private Set<BuilderRequestModal> builderRequests = new HashSet<>();

	public EndUserModal(Integer id, String firstName, String middleName, String lastName, String phoneNumber,
			String email, String addressLine1, String addressLine2, String city, String state, Role role,
			Set<ServiceRequestModal> serviceRequests, Set<BuilderRequestModal> builderRequests) {
		super();
		this.id = id;
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
		this.serviceRequests = serviceRequests;
		this.builderRequests = builderRequests;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Set<ServiceRequestModal> getServiceRequests() {
		return serviceRequests;
	}

	public void setServiceRequests(Set<ServiceRequestModal> serviceRequests) {
		this.serviceRequests = serviceRequests;
	}

	public Set<BuilderRequestModal> getBuilderRequests() {
		return builderRequests;
	}

	public void setBuilderRequests(Set<BuilderRequestModal> builderRequests) {
		this.builderRequests = builderRequests;
	}

	public static EndUserModal getModalFromEntity(EndUser endUserEntity) {
		Set<ServiceRequest> sRE = endUserEntity.getServiceRequests();
		Set<ServiceRequestModal> sRM = new HashSet<>();

		for (ServiceRequest sE : sRE) {
			ServiceRequestModal sM = ServiceRequestModal.getModalFromEntity(sE);
			sRM.add(sM);
		}

		Set<BuilderRequest> bRE = endUserEntity.getBuilderRequests();
		Set<BuilderRequestModal> bRM = new HashSet<>();

		for (BuilderRequest bE : bRE) {
			BuilderRequestModal bM = BuilderRequestModal.getModalFromEntity(bE);
			bRM.add(bM);
		}

		return new EndUserModal(endUserEntity.getId(), endUserEntity.getFirstName(), endUserEntity.getMiddleName(),
				endUserEntity.getLastName(), endUserEntity.getPhoneNumber(), endUserEntity.getEmail(),
				endUserEntity.getAddressLine1(), endUserEntity.getAddressLine2(), endUserEntity.getCity(),
				endUserEntity.getState(), endUserEntity.getRole(), sRM, bRM);
	}

	public static EndUser getEntityFromModal(EndUserModal endUserModal, String password) {

		return new EndUser(endUserModal.getId(), endUserModal.getFirstName(), endUserModal.getMiddleName(),
				endUserModal.getLastName(), endUserModal.getPhoneNumber(), endUserModal.getEmail(), password,
				endUserModal.getAddressLine1(), endUserModal.getAddressLine2(), endUserModal.getCity(),
				endUserModal.getState(), endUserModal.getRole(), new HashSet<>(), new HashSet<>());
	}

}
