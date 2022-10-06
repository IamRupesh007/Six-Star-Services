package com.project.construction.serviceimpl;

import java.sql.Date;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.construction.entity.EndUser;
import com.project.construction.entity.ServiceProvider;
import com.project.construction.entity.ServiceRequest;
import com.project.construction.entity.Status;
import com.project.construction.modal.ServiceRequestModal;
import com.project.construction.repository.EndUserRepository;
import com.project.construction.repository.ServiceProviderRepository;
import com.project.construction.repository.ServiceRequestRepository;
import com.project.construction.service.ServiceRequestService;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService {

	@Autowired
	private ServiceRequestRepository serviceRequestRepository;

	@Autowired
	private ServiceProviderRepository serviceProviderRepository;

	@Autowired
	private EndUserRepository endUserRepository;

	@Override
	public Integer createServiceRequest(ServiceRequestModal serviceRequestModal) {
		ServiceRequest serviceRequest = ServiceRequestModal.getEntityFromModal(serviceRequestModal);

		Optional<EndUser> opEn = endUserRepository.findById(serviceRequestModal.getCustomerId());
		EndUser user = null;
		if (opEn.isPresent()) {
			user = opEn.get();
		}

		Optional<ServiceProvider> opSp = serviceProviderRepository.findById(serviceRequestModal.getServiceProviderId());
		ServiceProvider serviceProvider = null;
		if (opSp.isPresent()) {
			serviceProvider = opSp.get();
		}

		serviceRequest.setCustomer(user);
		serviceRequest.setServiceProvider(serviceProvider);

		return serviceRequestRepository.save(serviceRequest).getId();
	}

	@Override
	public Set<ServiceRequestModal> getServiceRequestsForCustomer(Integer customerUserId) {
		Optional<EndUser> opEn = endUserRepository.findById(customerUserId);
		EndUser user = null;
		if (opEn.isPresent()) {
			user = opEn.get();
		}
		
		Set<ServiceRequestModal> serviceRequestModals = new TreeSet<>();
		for(ServiceRequest s:user.getServiceRequests()) {
			serviceRequestModals.add(ServiceRequestModal.getModalFromEntity(s));
		}
		return serviceRequestModals;
	}

	@Override
	public Set<ServiceRequestModal> getServiceRequestsForServiceProvider(Integer serviceProviderId) {
		// TODO Auto-generated method stub
		Optional<ServiceProvider> opSp = serviceProviderRepository.findById(serviceProviderId);
		ServiceProvider serviceProvider = null;
		if (opSp.isPresent()) {
			serviceProvider = opSp.get();
		}
		Set<ServiceRequestModal> serviceRequestModals = new TreeSet<>();
		for(ServiceRequest s:serviceProvider.getServiceRequests()) {
			serviceRequestModals.add(ServiceRequestModal.getModalFromEntity(s));
		}
		return serviceRequestModals;
	}

	@Override
	public void updateServiceRequest(Integer id) throws Exception {
		Optional<ServiceRequest> opSr = serviceRequestRepository.findById(id);
		ServiceRequest sr = null;
		if (opSr.isPresent()) {
			sr = opSr.get();
		}
		else {
			throw new Exception("Service request with this id does not exists");
		}
		sr.setCompletionDate(new Date(new java.util.Date().getTime()));
		sr.setStatus(Status.COMPLETED);
		serviceRequestRepository.save(sr);
		
	}

	@Override
	public Integer deleteServiceRequest(Integer id) {
		serviceRequestRepository.deleteById(id);
		return id;
	}

}
