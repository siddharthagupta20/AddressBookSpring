package com.cg.adbsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.cg.adbsp.dto.AddressBookDTO;
import com.cg.adbsp.dto.ResponseDTO;
import com.cg.adbsp.model.AddressBookData;
import com.cg.adbsp.service.AddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	@Autowired
	private AddressBookService addressBookService;
	
	@RequestMapping(value= {"","/","/get"})
	public ResponseEntity<List<AddressBookData>> getPersonData(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(addressBookService.getPersonData());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping("/get/{fName}")
	public ResponseEntity<AddressBookData> getPersonData(@PathVariable("fName") String firstName){
		return ResponseEntity.status(HttpStatus.OK).body(addressBookService.getPersonByFirstName(firstName));
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addPersonData(@RequestBody AddressBookDTO addressBookDTO){
		AddressBookData personData = addressBookService.createPersonData(addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Create Call Successful", personData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updatePersonData(@RequestBody AddressBookDTO addressBookDTO){
		AddressBookData personData = addressBookService.updatePersonData(addressBookDTO.getFirstName(),addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Update Call Successful", personData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{fName}")
	public ResponseEntity<ResponseDTO> deletePersonData(@PathVariable("fName") String firstName){
		addressBookService.deletePersonData(firstName);
		ResponseDTO respDTO = new ResponseDTO("Delete Call Successful", firstName);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
}
