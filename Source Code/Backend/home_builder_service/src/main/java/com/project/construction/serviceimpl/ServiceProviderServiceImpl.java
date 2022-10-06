package com.project.construction.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.construction.entity.EndUser;
import com.project.construction.entity.Role;
import com.project.construction.entity.ServiceProvider;
import com.project.construction.entity.ServiceType;
import com.project.construction.modal.EndUserModal;
import com.project.construction.modal.ServiceProviderModal;
import com.project.construction.modal.ServiceProviderResponse;
import com.project.construction.repository.EndUserRepository;
import com.project.construction.repository.ServiceProviderRepository;
import com.project.construction.service.EndUserService;
import com.project.construction.service.ServiceProviderService;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

	@Autowired
	private EndUserService endUserService;

	@Autowired
	private ServiceProviderRepository serviceProviderRepository;

	@Autowired
	private EndUserRepository endUserRepository;

	@Override
	public Integer createServiceProvider(ServiceProviderModal serviceProviderModal, EndUserModal endUserModal,
			String password) {
		Integer id = endUserService.createUser(endUserModal, password);
		
		Optional<EndUser> opEn = endUserRepository.findById(id);
		EndUser user = null;
		if (opEn.isPresent()) {
			user = opEn.get();
		}
		
		ServiceProvider sp = ServiceProviderModal.getEntityFromModal(serviceProviderModal);
		sp.setUser(user);
		return serviceProviderRepository.save(sp).getId();
	}

	@Override
	public ServiceProviderResponse login(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		EndUserModal userM = endUserService.login(email, password);
		if(!userM.getRole().equals(Role.SERVICE_PROVIDER)) {
			throw new Exception("Service provider with this email does not exist");
		}
		Integer id = userM.getId();
		List<ServiceProvider> sps = serviceProviderRepository.findByUserId(id);
		
		
		return ServiceProviderResponse.getResponseFromEntity(sps.get(0));
	}

	@Override
	public Integer deleteServiceProvider(Integer id) {
		serviceProviderRepository.deleteById(id);
		return id;
	}

	@Override
	public Set<ServiceProviderResponse> getServiceProvidersByServiceType(ServiceType serviceType) {
		List<ServiceType> sts = new ArrayList<>();
				sts.add(serviceType);
		List<ServiceProvider> allServiceProviders = serviceProviderRepository.findByServiceTypes(serviceType);
		Set<ServiceProviderResponse> serviceProviders = new HashSet<>();

		for(ServiceProvider sp:allServiceProviders) {
			ServiceProviderResponse spM = ServiceProviderResponse.getResponseFromEntity(sp);

			serviceProviders.add(spM);
			
		}
		return serviceProviders;
	}

}
