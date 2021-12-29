package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table; 

@Entity
@Table(name="bankinfo")
public class Bank {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bankid")
	private int Bankid;
	@Column(name="bankname")
	private String Bankname;
	@Column(name="bankbranch")
	private String Bankbranch;
	public Bank() {
		super();
	}
	public Bank(int bankid, String bankname, String bankbranch) {
		super();
		Bankid = bankid;
		Bankname = bankname;
		Bankbranch = bankbranch;
	}
	public int getBankid() {
		return Bankid;
	}
	public void setBankid(int bankid) {
		Bankid = bankid;
	}
	public String getBankname() {
		return Bankname;
	}
	public void setBankname(String bankname) {
		Bankname = bankname;
	}
	public String getBankbranch() {
		return Bankbranch;
	}
	public void setBankbranch(String bankbranch) {
		Bankbranch = bankbranch;
	}
	

}
