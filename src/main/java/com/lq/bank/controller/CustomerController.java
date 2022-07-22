package com.lq.bank.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lq.bank.exception.BranchNotFoundException;
import com.lq.bank.model.Branch;
import com.lq.bank.service.BranchService;
import com.lq.bank.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private BranchService branchService;
	
	
	@GetMapping
	public List<Map>  listOfAllCustomers() {		
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/{id}/accounts")
	public List<Map> listAllAccounts() {
		return customerService.getAllAccounts();
	}
	
	
	@GetMapping("/{id}")
	public List<Map> getCustomerInfo( @PathVariable("id") int userId  ) {
		return customerService.getCustomerInfo();
	}

	
	
	
	@PostMapping
	public String createNewCustomer(
			@ModelAttribute("branchId") int branchId,
			@ModelAttribute("name") String name,
			@ModelAttribute("family") String family,
			@ModelAttribute("age") int age		
			) {
		
	
		try {
			Branch tBranch = branchService.getBranchById(branchId);
			customerService.newCustomer(tBranch,name,family,age);			
		} catch (BranchNotFoundException e) {
			return "Branch not found";
		}
		
		return "Customer Created";
	}
	
	@PutMapping("/{id}")
	public String updateCustomer() {
		return "soon-Update";
	}
	
	@DeleteMapping("/{id}")
	public String deleteCustomer() {
		return "soon-Delete";
	}
	
	
	
	
	
	
	
	
	
}
