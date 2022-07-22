package com.lq.bank.model;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Transaction {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne
	@JoinColumn( name = "account_id" )
	private Account account;
	
	
	@Column
	private Timestamp calendarTimestamp;

	@Column
	private int amount;

	
	@Column
	private boolean isDeposit = true;
	

	public Transaction() {
		super();
	}


	public Transaction(Account account, Timestamp calendarTimestamp, int amount) {
		super();
		this.account = account;
		this.calendarTimestamp = calendarTimestamp;
		this.amount = amount;
	}
	
	


	public Transaction(Account account, Timestamp calendarTimestamp, int amount, boolean isDeposit) {
		super();
		this.account = account;
		this.calendarTimestamp = calendarTimestamp;
		this.amount = amount;
		this.isDeposit = isDeposit;
	}

	

	public boolean isDeposit() {
		return isDeposit;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public Timestamp getCalendarTimestamp() {
		return calendarTimestamp;
	}


	public void setCalendarTimestamp(Timestamp calendarTimestamp) {
		this.calendarTimestamp = calendarTimestamp;
	}


	public int getAmount() {
		return amount;
	}


	
	

}
