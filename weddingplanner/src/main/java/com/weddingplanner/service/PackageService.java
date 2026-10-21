package com.weddingplanner.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weddingplanner.dao.PackageDAO;
import com.weddingplanner.dto.PackageDTO;
import com.weddingplanner.dto.UserDTO;
import com.weddingplanner.exception.RecordNotFoundException;

@Service
public class PackageService {
	
	@Autowired
	private PackageDAO dao;
	
	public PackageDTO Add(PackageDTO dto) {
		PackageDTO pkg = null;
		pkg = dao.findByTitle(dto.getTitle());
		System.out.println("user by email........: "+pkg);
		if(pkg != null)
			throw new RecordNotFoundException("Package is already exists..");
		    System.out.println("dto Before Save: "+dto);
		    pkg = dao.save(dto);
	       return  pkg;
		}
		

		
		public PackageDTO findUserById(long id) {
			return dao.findById(id);
		}
		
		public PackageDTO findPackageById(long id) {
			return dao.findById(id);
		}
		
		public List<PackageDTO> list(){
			List<PackageDTO> dto = dao.findAll();
			return dto;
		}
		
		public PackageDTO update(PackageDTO dto){
			PackageDTO bean = dao.saveAndFlush(dto);
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

		public Blob getImageById(long id) throws SerialException, SQLException {		
			PackageDTO news = dao.findById(id);
			byte[] blob = news.getImage();
			Blob bBlob = new SerialBlob(blob);
			return bBlob;
		}
}
