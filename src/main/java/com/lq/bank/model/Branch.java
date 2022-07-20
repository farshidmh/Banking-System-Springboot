package com.lq.bank.model;

public class Branch {
	
	private int branchId;
		
	private String branchName;

	
	
	
	
	
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
