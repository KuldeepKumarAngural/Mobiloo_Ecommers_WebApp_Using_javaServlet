package com.mobiloo_AccountSection;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity@Table(name="SIGNUP_DETAILS")
public class SignUpDetails implements Serializable {
	
	private String name;
	@Id
	private String email;
	
	private String mobile;
	@OneToOne
	private PasswordClass password;
	
	private String dateOfBirth;

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	public PasswordClass getPassword() {
		return password;
	}

	public void setPassword(PasswordClass password) {
		this.password = password;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	

}
