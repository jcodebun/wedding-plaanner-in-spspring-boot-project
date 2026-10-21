package com.weddingplanner.form;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;


import com.weddingplanner.dto.BaseDTO;
import com.weddingplanner.dto.PackageDTO;
import com.weddingplanner.utility.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackageForm extends BaseDTO {

	@NotEmpty(message = "Title name is required")
	private String title;
	
	@NotEmpty(message = "Description name is required")
	private String description;
	
	@NotEmpty(message = "Price name is required")
	private String price;
	
	@NotEmpty(message = "Venue name is required")
	private String venue;
	
	@NotEmpty(message = "Amenities name is required")
	private String amenities;
	
	  public PackageDTO getDTO() {			
		  PackageDTO bean=new PackageDTO();			
			bean.setId(id);
	        bean.setTitle(title);
	        bean.setDescription(description);
	        bean.setVenue(venue);
	        bean.setPrice(DataUtility.getLong(price));
	        bean.setAmenities(amenities);
			return bean;
		}

		public void populate(PackageDTO bean) {
			id = bean.getId();
	       title = bean.getTitle();
	       description = bean.getDescription();
	       venue = bean.getVenue();
	       price = DataUtility.getStringData(bean.getPrice());
	       amenities = bean.getAmenities();

		}

}
