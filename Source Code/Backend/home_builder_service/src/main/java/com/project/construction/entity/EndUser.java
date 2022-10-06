package com.project.construction.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "end_user")
public class EndUser {

	
	public EndUser(Integer id, String firstName, String middleName, String lastName, String phoneNumber, String email,
			String password, String addressLine1, String addressLine2, String city, String state, Role role,
			Set<ServiceRequest> serviceRequests, Set<BuilderRequest> builderRequests) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.role = role;
		this.serviceRequests = serviceRequests;
		this.builderRequests = builderRequests;
	}

	public EndUser() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(unique = true)
	private String email;

	private String password;

	@Column(name = "address_line_1")
	private String addressLine1;

	@Column(name = "address_line_2")
	private String addressLine2;

	private String city;

	private String state;

	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(targetEntity = ServiceRequest.class, mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Set<ServiceRequest> serviceRequests = new HashSet<>();

	@OneToMany(targetEntity = BuilderRequest.class, mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Set<BuilderRequest> builderRequests = new HashSet<>();

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Set<ServiceRequest> getServiceRequests() {
		return serviceRequests;
	}

	public void setServiceRequests(Set<ServiceRequest> serviceRequests) {
		this.serviceRequests = serviceRequests;
	}

	public Set<BuilderRequest> getBuilderRequests() {
		return builderRequests;
	}

	public void setBuilderRequests(Set<BuilderRequest> builderRequests) {
		this.builderRequests = builderRequests;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.firstName+" "+this.id;
	}
	
	

}
