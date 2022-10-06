package com.project.construction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.construction.entity.EndUser;

@Repository
public interface EndUserRepository extends JpaRepository<EndUser, Integer> {
	
	public List<EndUser> findByEmail(String email);
	

}
