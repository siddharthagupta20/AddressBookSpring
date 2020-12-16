package com.cg.adbsp.dto;

import com.cg.adbsp.model.AddressBookData;

import lombok.Data;

@Data
public class ResponseDTO {
	private String message;
	private Object data;

	public ResponseDTO(String message, AddressBookData personData) {
		this.message = message;
		this.data = personData;
	}

	public ResponseDTO(String message, String firstName) {
		this.message = message;
	}
}
