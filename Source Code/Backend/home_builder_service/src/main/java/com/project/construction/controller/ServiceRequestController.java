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

import com.project.construction.modal.ServiceRequestModal;
import com.project.construction.modal.ServiceRequestRequest;
import com.project.construction.service.ServiceRequestService;

@RestController
@RequestMapping(value = "service-request")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServiceRequestController {

	@Autowired
	private ServiceRequestService serviceRequestService;

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public Map<String, String> createServiceRequest(@RequestBody ServiceRequestRequest serviceRequest) {
		ServiceRequestModal serviceRequestModal = ServiceRequestRequest.getModalFromRequest(serviceRequest);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Service request created with id "
				+ serviceRequestService.createServiceRequest(serviceRequestModal));
		return response;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/user_requests/{id}")
	public Set<ServiceRequestModal> getUserServiceRequest(@PathVariable Integer id) {
		return serviceRequestService.getServiceRequestsForCustomer(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/sp_requests/{id}")
	public Set<ServiceRequestModal> getServiceProvderServiceRequest(@PathVariable Integer id) {
		return serviceRequestService.getServiceRequestsForServiceProvider(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/done/{id}")
	public Map<String, String> updateServiceRequest(@PathVariable Integer id) throws Exception {
	
		serviceRequestService.updateServiceRequest(id);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Updated service request with id " + id);
		return response;
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/remove/{id}")
	public Map<String, String> deleteServiceRequest(@PathVariable Integer id) throws Exception {
		Integer res = serviceRequestService.deleteServiceRequest(id);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Service request deleted with id " + res);
		return response;

	}

}
