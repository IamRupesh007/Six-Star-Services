package com.project.construction.service;

import java.util.Set;

import com.project.construction.modal.ServiceRequestModal;

public interface ServiceRequestService {
	
	public Integer createServiceRequest(ServiceRequestModal serviceRequestModal);
	
	public Set<ServiceRequestModal> getServiceRequestsForCustomer(Integer customerUserId);

	public Set<ServiceRequestModal> getServiceRequestsForServiceProvider(Integer serviceProviderId);

	public void updateServiceRequest(Integer id) throws Exception;

	public Integer deleteServiceRequest(Integer id);

}
