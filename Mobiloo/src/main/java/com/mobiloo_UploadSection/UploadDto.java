package com.mobiloo_UploadSection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity@Table(name = "UPLOADED_ITEMS")
public class UploadDto {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String brand;
	private String description;
	private String price;
	private String grade;
	 @Lob
	    private byte[] image;
	 
	 private String base64Image;
     
	    public String getBase64Image() {
	        return base64Image;
	    }
	 
	    public void setBase64Image(String base64Image) {
	        this.base64Image = base64Image;
	    }
	
	public byte[] getimage() {
		return image;
	}
	public void setData(byte[] image) {
		this.image = image;
	}
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
	

}
