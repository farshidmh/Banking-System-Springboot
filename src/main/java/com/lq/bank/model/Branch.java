package com.lq.bank.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Branch {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int branchId;
		
	@Column
	private String branchName;

	
	@OneToMany( mappedBy = "branch" )
	private List<Customer> customers;
	
	@OneToMany( mappedBy = "branch" )
	private List<Account> accounts;
	
	
	public Branch() {
		super();
	}

	public Branch(String branchName) {
		super();
		this.branchName = branchName;
		System.out.println("Executed");
	}

	public Branch(int branchId, String branchName) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	

}
