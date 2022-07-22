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

@Entity
@Table
public class Customer {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String family;
	
	@Column
	private int age;
	
	@ManyToOne	
	@JoinColumn(name="branch_id")
	private Branch branch;
	
	
	@OneToMany( mappedBy = "customer" )
	private List<Account> accounts;
	
	
	
	public Customer() {
		super();
	}

	public Customer(int id, String name, String family, int age, Branch branch) {
		super();
		this.id = id;
		this.name = name;
		this.family = family;
		this.age = age;
		this.branch = branch;
	}

	public Customer(String name, String family, int age, Branch branch) {
		super();
		this.name = name;
		this.family = family;
		this.age = age;
		this.branch = branch;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Branch getBranch() {
		return branch;
	}



	public void setBranch(Branch branch) {
		this.branch = branch;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	

}
