package com.project.construction.modal;

import java.sql.Date;

import com.project.construction.entity.ServiceType;
import com.project.construction.entity.Status;

public class ServiceRequestRequest {

	private Status status;

	private Date createDate;

	private Date modifyDate;

	private ServiceType serviceType;

	private Integer customerId;

	private Integer serviceProviderId;

	public ServiceRequestRequest() {

	}

	public ServiceRequestRequest(Status status, Date createDate, Date modifyDate, ServiceType serviceType,
			Integer customerId, Integer serviceProviderId) {
		super();
		this.status = status;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.serviceType = serviceType;
		this.customerId = customerId;
		this.serviceProviderId = serviceProviderId;
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

	public static ServiceRequestModal getModalFromRequest(ServiceRequestRequest req) {

		return new ServiceRequestModal(null, req.getStatus(), req.getCreateDate(), req.getModifyDate(), null,
				req.getServiceType(), req.getCustomerId(), req.getServiceProviderId(), null, null);

	}

}
