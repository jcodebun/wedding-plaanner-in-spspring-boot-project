package com.weddingplanner.form;

import javax.validation.constraints.NotEmpty;

import com.weddingplanner.dto.BaseDTO;
import com.weddingplanner.dto.BookingDTO;
import com.weddingplanner.utility.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingForm extends BaseDTO {

	
	private String packageId;
	
	@NotEmpty(message = "First Name name is required")
	private String firstName;

	@NotEmpty(message = "Last Name is required")
	private String lastName;
	
	@NotEmpty(message = "Email is required")
	private String email;
	
	@NotEmpty(message = "Phone Number is required")
	private String phoneNumber;
	
	@NotEmpty(message = "Title name is required")
	private String title;
	
	@NotEmpty(message = "Date is required")
	private String date;
	
	@NotEmpty(message = "Price is required")
	private String price;
	

	  public BookingDTO getDTO() {			
		  BookingDTO bean=new BookingDTO();			
			bean.setId(id);
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setEmail(email);
			bean.setPhoneNumber(phoneNumber);
	        bean.setTitle(title);
	        bean.setDate(date);
	        bean.setPrice(DataUtility.getLong(price));
	        bean.setPackageId(DataUtility.getLong(packageId));
	       
			return bean;
		}

		public void populate(BookingDTO bean) {
			id = bean.getId();
			firstName = bean.getFirstName();
			lastName = bean.getLastName();
			email = bean.getEmail();
			phoneNumber = bean.getPhoneNumber();
	        title = bean.getTitle();
	        date = bean.getDate();
	        price = DataUtility.getStringData(bean.getPrice());
	        packageId = DataUtility.getStringData(bean.getPackageId());

		}
	
}
