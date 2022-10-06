package com.project.construction.modal;

import java.sql.Date;

import com.project.construction.entity.ServiceRequest;
import com.project.construction.entity.ServiceType;
import com.project.construction.entity.Status;

public class ServiceRequestModal implements Comparable<ServiceRequestModal> {
	
	@Override
	public int compareTo(ServiceRequestModal e) {
		int hash = this.createDate.compareTo(e.createDate);
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
	
	public ServiceRequestModal() {
		super();
	}

	private Integer id;

	private Status status;

	private Date createDate;

	private Date modifyDate;

	private Date completionDate;

	private ServiceType serviceType;

	private Integer customerId;

	private Integer serviceProviderId;

	private String customerName;

	private String serviceProviderName;

	public ServiceRequestModal(Integer id, Status status, Date createDate, Date modifyDate, Date completionDate,
			ServiceType serviceType, Integer customerId, Integer serviceProviderId, String customerName,
			String serviceProviderName) {
		super();
		this.id = id;
		this.status = status;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.completionDate = completionDate;
		this.serviceType = serviceType;
		this.customerId = customerId;
		this.serviceProviderId = serviceProviderId;
		this.customerName = customerName;
		this.serviceProviderName = serviceProviderName;
	}

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

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(Integer serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerId(String customerName) {
		this.customerName = customerName;
	}

	public String getServiceProviderName() {
		return serviceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}

	public static ServiceRequestModal getModalFromEntity(ServiceRequest serviceRequest) {
		String name = serviceRequest.getCustomer().getFirstName() +" "+ serviceRequest.getCustomer().getLastName();
		return new ServiceRequestModal(serviceRequest.getId(), serviceRequest.getStatus(),
				serviceRequest.getCreateDate(), serviceRequest.getModifyDate(), serviceRequest.getCompletionDate(),
				serviceRequest.getServiceType(), serviceRequest.getCustomer().getId(),
				serviceRequest.getServiceProvider().getId(), name,
				serviceRequest.getServiceProvider().getServiceProviderName());
	}

	public static ServiceRequest getEntityFromModal(ServiceRequestModal serviceRequestModal) {
		return new ServiceRequest(serviceRequestModal.getId(), serviceRequestModal.getStatus(),
				serviceRequestModal.getCreateDate(), serviceRequestModal.getModifyDate(),
				serviceRequestModal.getCompletionDate(), serviceRequestModal.getServiceType(), null, null);
	}

}
