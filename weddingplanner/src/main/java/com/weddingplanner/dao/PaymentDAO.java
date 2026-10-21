package com.weddingplanner.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weddingplanner.dto.PaymentDTO;
import com.weddingplanner.dto.UserDTO;

public interface PaymentDAO extends JpaRepository<PaymentDTO, Long> {
	
	public PaymentDTO findById(long id);
	public List<PaymentDTO> findByEmail(String email);

}
