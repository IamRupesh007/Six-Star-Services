package com.project.construction.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "service_request")
public class ServiceRequest {
	
	public ServiceRequest() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ServiceRequest(Integer id, Status status, Date createDate, Date modifyDate, Date completionDate,
			ServiceType serviceType, EndUser customer, ServiceProvider serviceProvider) {
		super();
		this.id = id;
		this.status = status;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.completionDate = completionDate;
		this.serviceType = serviceType;
		this.customer = customer;
		this.serviceProvider = serviceProvider;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "modify_date")
	private Date modifyDate;

	@Column(name = "completion_date")
	private Date completionDate;

	@Column(name = "service_type")
	@Enumerated(EnumType.STRING)
	private ServiceType serviceType;

	@ManyToOne(fetch = FetchType.LAZY)
	private EndUser customer;

	@ManyToOne(fetch = FetchType.LAZY)
	private ServiceProvider serviceProvider;

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public Date getModifyDate() {
		return modifyDate;
	}



	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}



	public Date getCompletionDate() {
		return completionDate;
	}



	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}



	public ServiceType getServiceType() {
		return serviceType;
	}



	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}



	public EndUser getCustomer() {
		return customer;
	}



	public void setCustomer(EndUser customer) {
		this.customer = customer;
	}



	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}



	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	
	

}
