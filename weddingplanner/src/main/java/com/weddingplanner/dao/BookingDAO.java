package com.weddingplanner.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weddingplanner.dto.BookingDTO;


public interface BookingDAO extends JpaRepository<BookingDTO, Long> {

	public BookingDTO findById(long id);
	public BookingDTO findByUserId(long id);
	public List<BookingDTO> findByEmail(String email);
	public BookingDTO findByDateAndTitle(String date, String title );
}
