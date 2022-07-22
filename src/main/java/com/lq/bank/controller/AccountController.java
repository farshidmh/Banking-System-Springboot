package com.lq.bank.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lq.bank.enums.AccountType;
import com.lq.bank.exception.AccountNotFoundException;
import com.lq.bank.exception.BranchNotFoundException;
import com.lq.bank.exception.CustomerNotFoundException;
import com.lq.bank.model.Account;
import com.lq.bank.model.Branch;
import com.lq.bank.model.Customer;
import com.lq.bank.service.AccountService;
import com.lq.bank.service.BranchService;
import com.lq.bank.service.CustomerService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	/*
	 * checking => 1 savings => 2 salary => 3 credit => 4
	 */
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private BranchService branchService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Map> listAllAccounts() {
		return accountService.getAllAccounts();
	}

	@GetMapping("/{id}")
	public List<Map> getAccountInfo() {
		return accountService.getAccountInfo();
	}

	
	@PutMapping("/{id}")
	public String updateAccount() {
		return "soon-update";
	}
	
	@DeleteMapping("/{id}")
	public String deleteAccount() {
		return "soon-update";
	}
	
	@PostMapping
	public String createAccount() {
		
		
		try {
			Branch branch = branchService.getBranchById(65);
			
			Customer customer = customerService.getCustomerById(33);
			
			
			accountService.createNewAccount(branch, customer, "First Account", AccountType.CHECKING);
			
			
			
		} catch (BranchNotFoundException e) {
			return "Branch not found";
		} catch (CustomerNotFoundException e) {
			return "Customer not found";
		}
		
		
		
		
		
		
		return "soon-update";
	}
	
	@GetMapping("/{id}/balance")
	public int getAccountBalance() {
		int b = accountService.calculateAccountBalance();
		return b;
	}
	
	@PostMapping("/{id}/deposit")
	public String depositAccount( @PathVariable("id") int accountId ) {
				
		try {
			Account account = accountService.getAccountById(1);
						
			accountService.deposit(account, 100);

		} catch (AccountNotFoundException e) {
			return "Account not found";
		}
		
		
		return "soon-update";
	}
	
	@PostMapping("/{id}/withdrawal")
	public String wthdrawalAccount() {
		
		try {
			Account account = accountService.getAccountById(1);
						
			accountService.withdrawal(account, 10);

		} catch (AccountNotFoundException e) {
			return "Account not found";
		}
		
		return "soon-update";
	}
	
	
	
}
