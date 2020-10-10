package com.umermahmood.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umermahmood.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
	public List<License> findAll();
	
}