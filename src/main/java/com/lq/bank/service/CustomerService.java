package com.lq.bank.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lq.bank.data.BranchRepository;
import com.lq.bank.data.CustomerRepository;
import com.lq.bank.enums.AccountType;
import com.lq.bank.exception.BranchNotFoundException;
import com.lq.bank.exception.CustomerNotFoundException;
import com.lq.bank.model.Account;
import com.lq.bank.model.Branch;
import com.lq.bank.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private AccountService accountService;

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BranchService branchService;

	public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
		Optional<Customer> cOptional = customerRepository.findById(customerId);
		if (cOptional.isEmpty()) {
			throw new CustomerNotFoundException();
		}
		Customer customer = cOptional.get();
		return customer;
	}

	public void newCustomer(Branch branch, String name, String family, int age) {
		Customer tempCustomer = new Customer(name, family, age, branch);
		customerRepository.save(tempCustomer);
	}

	public Map buildCustomerInfoMap(Customer customer) {

		Map<String, Object> customerInfo = new HashMap();
		customerInfo.put("name", customer.getName());
		customerInfo.put("family", customer.getFamily());
		customerInfo.put("age", customer.getAge());
		customerInfo.put("customerId", customer.getId());

		return customerInfo;
	}

	public List<Map> getAllCustomers() {

		List<Map> customersList = new ArrayList<Map>();

		Branch branchB = new Branch(2, "Branch B");

		Customer c1 = new Customer(1, "John", "Sheppard", 42, branchB);
		Customer c2 = new Customer(2, "Jason", "Momoa", 48, branchB);

		customersList.add(buildCustomerInfoMap(c1));
		customersList.add(buildCustomerInfoMap(c2));

		return customersList;
	}

	public List<Map> getAllAccounts() {

		List<Map> accountList = new ArrayList<Map>();

		Map<String, Object> accountInfo = new HashMap<String, Object>();

		//Branch branchA = new Branch(1, "Branch A");
		//Customer c1 = new Customer("Rodney", "Mckay", 10, branchA);
		//Account ac_1 = new Account(1, "Ch 1", AccountType.SAVINGS, branchA, c1);
		//accountList.add(accountService.buildAccountInfo(ac_1));

		return accountList;
	}

	public List<Map> getCustomerInfo() {
		List<Map> customersList = new ArrayList<Map>();

		Branch branchB = new Branch(2, "Branch B");
		Customer customer = new Customer(1, "John", "Sheppard", 42, branchB);

		customersList.add(buildCustomerInfoMap(customer));

		return customersList;

	}

}
