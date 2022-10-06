package com.project.construction.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.project.construction.entity.EndUser;
import com.project.construction.entity.Role;
import com.project.construction.entity.ServiceProvider;
import com.project.construction.entity.ServiceRequest;
import com.project.construction.modal.AllUserModal;
import com.project.construction.modal.EndUserModal;
import com.project.construction.modal.ServiceProviderResponse;
import com.project.construction.modal.ServiceRequestModal;
import com.project.construction.repository.EndUserRepository;
import com.project.construction.repository.ServiceProviderRepository;
import com.project.construction.repository.ServiceRequestRepository;
import com.project.construction.service.EndUserService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

@Service
public class EndUserServiceImpl implements EndUserService {

	@Value("${secret_key}")
	private String secretKey;
	
	@Autowired
	private EndUserRepository endUserRepository;
	
	@Autowired
	private ServiceProviderRepository serviceProviderRepository;
	
	@Autowired
	private ServiceRequestRepository serviceRequestRepository;

	@Override
	public Integer createUser(EndUserModal endUserModal, String password) {
		try {
			password = this.hashPassword(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();

		}
		EndUser endUser = EndUserModal.getEntityFromModal(endUserModal, password);
		endUser = endUserRepository.save(endUser);
		return endUser.getId();
	}


	@Override
	public EndUserModal getUser(Integer id) {
		// TODO Auto-generated method stub
		Optional<EndUser> opUser = endUserRepository.findById(id);
		EndUser user = null;
		if(opUser.isPresent()) {
			user = opUser.get();
		}
		return EndUserModal.getModalFromEntity(user);
	}
	
	@Override
	public EndUserModal login(String email, String password) throws Exception {
		List<EndUser> endUsers = endUserRepository.findByEmail(email);
		if(endUsers.isEmpty()) {
			throw new Exception("Invalid Email");
		}
		password = this.hashPassword(password);
		EndUser user = endUsers.get(0);
		if(!password.equals(user.getPassword())){
			throw new Exception("Invalid password");
		}
		
		return EndUserModal.getModalFromEntity(user);
	}
	
	
	public String hashPassword(String password) throws NoSuchAlgorithmException, NoSuchProviderException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(secretKey.getBytes());
		byte[] bytes = md.digest(password.getBytes());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}


	@Override
	public AllUserModal getAllUsers() {
		List<EndUser> allUsers = endUserRepository.findAll();
		List<ServiceProvider> allServiceProviders = serviceProviderRepository.findAll();
		

		Set<EndUserModal> customers = new TreeSet<>();
		Set<EndUserModal> admins = new TreeSet<>();
		

		for(EndUser user:allUsers) {
			EndUserModal userM = EndUserModal.getModalFromEntity(user);
			if(userM.getRole().equals(Role.CUSTOMER)) {
				customers.add(userM);
			}
			if(userM.getRole().equals(Role.ADMIN)) {
				admins.add(userM);
			}
		}
		Set<ServiceProviderResponse> serviceProviders = new TreeSet<>();

		for (ServiceProvider sp : allServiceProviders) {
			ServiceProviderResponse spM = ServiceProviderResponse.getResponseFromEntity(sp);

			serviceProviders.add(spM);

		}
		
		List<ServiceRequest> allReq = serviceRequestRepository.findAll();
		Set<ServiceRequestModal> serviceRequestModals = new TreeSet<>();
		for(ServiceRequest s:allReq) {
			serviceRequestModals.add(ServiceRequestModal.getModalFromEntity(s));
		}
		
		return new AllUserModal(serviceProviders, customers, admins,serviceRequestModals);
	}


	@Override
	public Integer deleteUser(Integer id) {
		
		 endUserRepository.deleteById(id);
		return id;
	}




}
