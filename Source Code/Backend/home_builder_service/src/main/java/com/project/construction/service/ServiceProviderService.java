package com.project.construction.service;

import java.util.Set;

import com.project.construction.entity.ServiceType;
import com.project.construction.modal.EndUserModal;
import com.project.construction.modal.ServiceProviderModal;
import com.project.construction.modal.ServiceProviderResponse;


public interface ServiceProviderService {
	
	public Integer createServiceProvider(ServiceProviderModal serviceProviderModal, EndUserModal endUserModal, String password);

	public ServiceProviderResponse login(String email, String password) throws Exception;

	public Integer deleteServiceProvider(Integer id);

	public Set<ServiceProviderResponse> getServiceProvidersByServiceType(ServiceType serviceType);

}
