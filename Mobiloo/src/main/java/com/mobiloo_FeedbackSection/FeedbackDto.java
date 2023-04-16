package com.mobiloo_FeedbackSection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity@Table(name = "FEEDBACK_MESSAGE")
public class FeedbackDto {
	
	@Id
	private  String number;
	private String name;
	private String email;
	private String country;
	private String message;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

}
