package com.weddingplanner.dto;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="package")
@Getter
@Setter
public class PackageDTO extends BaseDTO  {
	
	@Column(name = "title", length = 755)
	private String title;
	
	@Column(name = "description", length = 755)
	private String description;
	
	@Column(name = "venue", length = 755)
	private String venue;
	
	@Column(name = "amenities", length = 1500)
	private String amenities;
	

	@Column(name = "price")
	private long price;
	
	@Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

	@Override
	public String toString() {
		return "PackageDTO [title=" + title + ", description=" + description + ", venue=" + venue + ", amenities="
				+ amenities + ", price=" + price + ", image=" + Arrays.toString(image) + "]";
	}

	
	
}
