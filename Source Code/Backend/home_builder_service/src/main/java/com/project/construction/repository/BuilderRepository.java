package com.project.construction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.construction.entity.Builder;

@Repository
public interface BuilderRepository extends JpaRepository<Builder, Integer> {

}
