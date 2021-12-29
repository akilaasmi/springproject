package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Bank;
import com.example.demo.repository.BankRepository;

@Service
public class BankService {
@Autowired
BankRepository bankrep;
	public String insertData(Bank bank)
	{
	
       
           int i=bank.getBankid();
           System.out.println(i);
           Optional <Bank> b= bankrep.findById(i);
   		if(b.isPresent())
   		{
   			System.out.println("present");
   			return "Data exist";
   			
   		}
   		else
   		{

		bank.getBankid();
		bank.getBankname();
	
		bank.getBankbranch();
		bankrep.save(bank);
		
		return "Data Inserted";
		}
		
		
	}
	public List<Bank> getAllDetails()
	{ 
		
		
	         return bankrep.findAll();
		      
	}
	
	public  Bank getById(int id)
	{
		Optional <Bank> b= bankrep.findById(id);
		
	   if( b.isPresent()  && b!=null)
	   {
	    return b.get();
	   }
	return new Bank();
	}
	
	public String deleteInfo(int id)
	{  
		Optional <Bank> b= bankrep.findById(id);
		
	      if(b.isPresent())
	      {
		bankrep.deleteById(id);
		
	        return "Data Deleted";
	      }
	      else
	      {
	    	  return "Mismatch data";
	      }
	
	 
	 
	}
	public String updateInfo(Bank bank, int id)
	{
		Optional <Bank> b= bankrep.findById(id);
		
		
		if(b.isPresent())
		{
		Bank b1=b.get();
		b1.setBankid(bank.getBankid());
		b1.setBankname(bank.getBankname());
		b1.setBankbranch(bank.getBankbranch());
		bankrep.save(b1);
		return "Data Updated";
		}
		
		else
		{
	return "Data Not Match";
		}
		
	
	}
}


