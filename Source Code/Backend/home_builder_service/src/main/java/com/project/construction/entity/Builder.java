package com.project.construction.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Builder {

	public Builder(Integer id, String builderName, EndUser user, Set<ServiceProvider> serviceProviders,
			Set<BuilderRequest> builderRequests) {
		super();
		this.id = id;
		this.builderName = builderName;
		this.user = user;
		this.serviceProviders = serviceProviders;
		this.builderRequests = builderRequests;
	}

	public Builder() {super();}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "builder_name")
	private String builderName;

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private EndUser user;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ServiceProvider> serviceProviders = new HashSet<>();

	@OneToMany(targetEntity = BuilderRequest.class, mappedBy = "builder", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Set<BuilderRequest> builderRequests = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBuilderName() {
		return builderName;
	}

	public void setBuilderName(String builderName) {
		this.builderName = builderName;
	}

	public EndUser getUser() {
		return user;
	}

	public void setUser(EndUser user) {
		this.user = user;
	}

	public Set<ServiceProvider> getServiceProviders() {
		return serviceProviders;
	}

	public void setServiceProviders(Set<ServiceProvider> serviceProviders) {
		this.serviceProviders = serviceProviders;
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
		return "builder "+this.builderName;
	}

}
