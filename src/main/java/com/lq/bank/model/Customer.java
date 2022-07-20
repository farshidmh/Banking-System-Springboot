package com.lq.bank.model;

public class Customer {
	
	private String name;
	
	private String family;
	
	private int age;
	
	private Branch branch;
	
	
	
	
	
	
	
	
	
	public Customer(String name, String family, int age, Branch branch) {
		super();
		this.name = name;
		this.family = family;
		this.age = age;
		this.branch = branch;
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
