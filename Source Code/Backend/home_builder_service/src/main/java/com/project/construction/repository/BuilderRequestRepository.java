package com.project.construction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.construction.entity.BuilderRequest;

@Repository
public interface BuilderRequestRepository extends JpaRepository<BuilderRequest, Integer> {

}