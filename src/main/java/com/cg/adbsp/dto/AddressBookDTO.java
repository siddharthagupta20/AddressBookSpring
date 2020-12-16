package com.cg.adbsp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AddressBookDTO {
	@NotEmpty(message="first name should not be empty")
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z]{2,}$",message="Invalid first name")
	private String firstName;
	
	@NotEmpty(message="last name should not be empty")
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z]{2,}$",message="Invalid last name")
	private String lastName;
	
	private String address;
	@Pattern(regexp="^[A-Z][a-z]{2,}$",message="Invalid city")
	private String city;
	@Pattern(regexp="^[A-Z][a-z]{2,}$",message="Invalid state")
	private String state;
	@Pattern(regexp="^[1-9]{1}[0-9]{5}$",message="Invalid zipcode")
	private String zip;
	@Pattern(regexp="^[6-9]{1}[0-9]{9}",message="Phone number should be 10 digits")
	private String phoneNumber;
	@Pattern(regexp="^([a][b][c])[.]([a-zA-Z]+)@bl.co(([.][a-zA-Z]{2}){1})$",message="Invalid email")
	private String email;
}
