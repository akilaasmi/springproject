package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bank;
import com.example.demo.repository.BankRepository;
import com.example.demo.service.BankService;

@RestController
public class BankDetailsController {
	@Autowired
	BankRepository bankrep;
	@Autowired
	BankService bankser;
@PostMapping("/insert")
public ResponseEntity<?> insertdata(@RequestBody Bank bank)
{ 
	try
{
	
    return ResponseEntity.ok(bankser.insertData(bank));
}
catch(Exception e)
{
	return ResponseEntity.unprocessableEntity().body("No Proper Input");
}
}
@GetMapping("/getall")

public  ResponseEntity<?> getdetails()
{
	
	try
	{
	return ResponseEntity.ok(bankser.getAllDetails()) ;
	}
	catch(Exception e)
	{
		return ResponseEntity.unprocessableEntity().body("No Data Available");
	}
}
@GetMapping("/getid/{id}")

	public ResponseEntity<?> get_id(@PathVariable int id)
	{
	try
	{
		return ResponseEntity.ok(bankser.getById(id));
		
	}
	catch(Exception e)
	{
		return ResponseEntity.unprocessableEntity().body("ID mismatch");
	}
		
	}
@DeleteMapping("/delete/{id}")
public ResponseEntity<?> deleteinfo(@PathVariable int id)
{
	try
	{
	return ResponseEntity.ok(bankser.deleteInfo(id));
	}
	catch(Exception e)
	{
		return ResponseEntity.unprocessableEntity().body("The requested Id is not Availble");
	}
}

@PutMapping("/update/{id}")
public ResponseEntity<?> updatebank(@PathVariable int id,@RequestBody Bank bank)
{
	try
	{

	return ResponseEntity.ok(bankser.updateInfo(bank,id));
	}
	catch(Exception e)
	{
		return ResponseEntity.unprocessableEntity().body("Impoper ID");
	}
}
}