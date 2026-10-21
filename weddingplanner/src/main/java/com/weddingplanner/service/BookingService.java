package com.weddingplanner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.weddingplanner.dao.BookingDAO;
import com.weddingplanner.dto.BookingDTO;


@Service
public class BookingService {

	@Autowired
	private BookingDAO dao;
	
	public BookingDTO Add(BookingDTO dto) {
		BookingDTO pkg = null;

		    pkg = dao.save(dto);
	       return  pkg;
		}
		

		
		public BookingDTO findBookingById(long id) {
			return dao.findById(id);
		}
		
		public BookingDTO findPackageById(long id) {
			return dao.findById(id);
		}
		
		public List<BookingDTO> list(){
			List<BookingDTO> dto = dao.findAll();
			return dto;
		}
		
		public List<BookingDTO> list(String email){
			List<BookingDTO> dto = dao.findByEmail(email);
			return dto;
		}
		
		public BookingDTO update(BookingDTO dto){
			BookingDTO bean = dao.saveAndFlush(dto);
			return bean;
		}
		
		public void delete(long id) throws Exception {
			if(id>0)
			{
				dao.deleteById(id);
			}else {
				throw new Exception("Not a valid id");
			}
			
		}
}
