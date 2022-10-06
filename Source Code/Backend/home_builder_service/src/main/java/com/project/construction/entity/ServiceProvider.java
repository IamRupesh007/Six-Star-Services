package com.project.construction.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;




@Entity
@Table(name = "service_provider")

public class ServiceProvider {
	
	

	public ServiceProvider(Integer id, String serviceProviderName, EndUser user, Set<ServiceType> serviceTypes,
			Set<ServiceRequest> serviceRequests) {
		super();
		this.id = id;
		this.serviceProviderName = serviceProviderName;
		this.user = user;
		this.serviceTypes = serviceTypes;
		this.serviceRequests = serviceRequests;
	}

	public ServiceProvider() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "service_provider_name")
	private String serviceProviderName;

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private EndUser user;

	@ElementCollection(targetClass = ServiceType.class)
	@CollectionTable(name = "service_provider_service_type", joinColumns = @JoinColumn(name = "service_provider_id"))
	@Enumerated(EnumType.STRING)
	@Column(name = "skill_name")
	private Set<ServiceType> serviceTypes;

	@OneToMany(targetEntity = ServiceRequest.class, mappedBy = "serviceProvider", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Set<ServiceRequest> serviceRequests = new HashSet<>();
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.serviceProviderName;
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

	public EndUser getUser() {
		return user;
	}

	public void setUser(EndUser user) {
		this.user = user;
	}

	public Set<ServiceType> getServiceTypes() {
		return serviceTypes;
	}

	public void setServiceTypes(Set<ServiceType> serviceTypes) {
		this.serviceTypes = serviceTypes;
	}

	public Set<ServiceRequest> getServiceRequests() {
		return serviceRequests;
	}

	public void setServiceRequests(Set<ServiceRequest> serviceRequests) {
		this.serviceRequests = serviceRequests;
	}
	
	
	

}
