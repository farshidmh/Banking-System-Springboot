package com.lq.bank.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lq.bank.enums.AccountType;

@Entity
@Table
public class Account {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column
	private String label;

	
	private AccountType type;	
	
	@ManyToOne
	@JoinColumn( name="branch_id" )
	private Branch branch;
	
	
	@ManyToOne
	@JoinColumn( name="customer_id" )
	private Customer customer;	
	
	
	@OneToMany( mappedBy = "account" )
	private List<Transaction> transactions;
	
	
	
	
	

	public Account() {
		super();
	}

	public Account(String label, AccountType type, Branch branch, Customer customer) {
		super();
		this.label = label;
		this.type = type;
		this.branch = branch;
		this.customer = customer;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
	
	

}
