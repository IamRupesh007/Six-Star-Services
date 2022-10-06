package com.project.construction.modal;

import java.util.HashSet;
import java.util.Set;

import com.project.construction.entity.BuilderRequest;
import com.project.construction.entity.Builder;

import com.project.construction.entity.ServiceProvider;


public class BuilderModal {
	
	public BuilderModal() {
		super();
	}

	private Integer id;

	private String builderName;

	private EndUserModal user;

	private Set<ServiceProvider> serviceProviders = new HashSet<>();

	private Set<BuilderRequestModal> builderRequests = new HashSet<>();

	public BuilderModal(Integer id, String builderName, EndUserModal user, Set<ServiceProvider> serviceProviders,
			Set<BuilderRequestModal> builderRequests) {
		super();
		this.id = id;
		this.builderName = builderName;
		this.user = user;
		this.serviceProviders = serviceProviders;
		this.builderRequests = builderRequests;
	}

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

	public EndUserModal getUser() {
		return user;
	}

	public void setUser(EndUserModal user) {
		this.user = user;
	}

	public Set<ServiceProvider> getServiceProviders() {
		return serviceProviders;
	}

	public void setServiceProviders(Set<ServiceProvider> serviceProviders) {
		this.serviceProviders = serviceProviders;
	}

	public Set<BuilderRequestModal> getBuilderRequests() {
		return builderRequests;
	}

	public void setBuilderRequests(Set<BuilderRequestModal> builderRequests) {
		this.builderRequests = builderRequests;
	}

	public static BuilderModal getModalFromEntity(Builder builderEntity) {
		EndUserModal user = EndUserModal.getModalFromEntity(builderEntity.getUser());

		Set<BuilderRequestModal> builderRequests = new HashSet<>();
		for (BuilderRequest bR : builderEntity.getBuilderRequests()) {
			BuilderRequestModal b = BuilderRequestModal.getModalFromEntity(bR);
			builderRequests.add(b);
		}
		return new BuilderModal(builderEntity.getId(), builderEntity.getBuilderName(), user,
				builderEntity.getServiceProviders(), builderRequests);
	}

	public static Builder getEntityFromModal(BuilderModal builderModal) {
		Set<BuilderRequest> builderRequests = new HashSet<>();
		for (BuilderRequestModal b : builderModal.getBuilderRequests()) {
			BuilderRequest br = BuilderRequestModal.getEntityFromModal(b);
			builderRequests.add(br);
		}
		return new Builder(builderModal.getId(), builderModal.getBuilderName(), null,
				builderModal.getServiceProviders(), builderRequests);
	}

}
