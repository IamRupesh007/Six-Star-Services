package com.project.construction.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.construction.entity.ServiceType;
import com.project.construction.modal.ServiceProviderData;
import com.project.construction.modal.ServiceProviderResponse;
import com.project.construction.service.ServiceProviderService;

@RestController
@RequestMapping(value = "provider")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServiceProviderController {

	@Autowired
	private ServiceProviderService providerService;

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public Map<String, String> createUser(@RequestBody ServiceProviderData spData) {

		Integer id = providerService.createServiceProvider(spData.getServiceProvider(), spData.getUser(),
				spData.getPassword());
		Map<String, String> response = new HashMap<>();
		response.put("message", "Service Provider created with id " + id);
		return response;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/login/{email}/{password}")
	public ServiceProviderResponse login(@PathVariable String email, @PathVariable String password) throws Exception {
		return providerService.login(email, password);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/remove/{id}")
	public Map<String, String> deleteServiceProvider(@PathVariable Integer id) throws Exception {
		Integer res = providerService.deleteServiceProvider(id);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Service provider deleted with id " + res);
		return response;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/get/{serviceType}")
	public Set<ServiceProviderResponse> getServiceProvidersByRole(@PathVariable ServiceType serviceType)
			throws Exception {
		return providerService.getServiceProvidersByServiceType(serviceType);
	}

}
