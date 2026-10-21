package com.weddingplanner.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="booking")
@Getter
@Setter
public class BookingDTO extends BaseDTO{
	
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "packageId")
	private long packageId;
	
	@Column(name = "firstName", length = 755)
	private String firstName;

	@Column(name = "lastName", length = 755)
	private String lastName;
	
	@Column(name = "email", length = 755)
	private String email;
	
	@Column(name = "phoneNumber", length = 755)
	private String phoneNumber;
	
	@Column(name = "title", length = 755)
	private String title;
	
	@Column(name = "date", length = 755)
	private String date;
	
	@Column(name = "price")
	private long price;
	
	@Column(name = "status", length = 755)
	private String status;
	


}
