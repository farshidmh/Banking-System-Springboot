package com.lq.bank.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lq.bank.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	/*
	 * checking => 1 savings => 2 salary => 3 credit => 4
	 */
	
	@Autowired
	private AccountService accountService;

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
		return "soon-update";
	}
	
	@PostMapping("/{id}/deposit")
	public String depositAccount() {
		return "soon-update";
	}
	
	@PostMapping("/{id}/withdrawal")
	public String wthdrawalAccount() {
		return "soon-update";
	}
	
	
	
}
