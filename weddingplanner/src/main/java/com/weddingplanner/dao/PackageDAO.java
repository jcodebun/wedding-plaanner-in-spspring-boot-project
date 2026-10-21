package com.weddingplanner.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weddingplanner.dto.PackageDTO;


public interface PackageDAO extends JpaRepository<PackageDTO, Long> {
	
	public PackageDTO findById(long id);
	public PackageDTO findByTitle(String title);

}