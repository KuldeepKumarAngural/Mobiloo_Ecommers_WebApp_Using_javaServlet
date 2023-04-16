package com.mobiloo_AccountSection;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity@Table(name = "PASSWORD_DETAILS")
public class PasswordClass implements Serializable {

	@OneToOne
	private SignUpDetails details;
	@Id
	private String password;
	
	public SignUpDetails getDetails() {
		return details;
	}
	public void setDetails(SignUpDetails details) {
		this.details = details;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
