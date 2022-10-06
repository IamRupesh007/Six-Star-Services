package com.project.construction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.construction.entity.ServiceProvider;
import com.project.construction.entity.ServiceType;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Integer> {

	public List<ServiceProvider> findByUserId(Integer id);
	
	public List<ServiceProvider> findByServiceTypes(ServiceType serviceType);

}