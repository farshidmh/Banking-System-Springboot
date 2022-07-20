package com.lq.bank.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	public List<Map> getAllCustomers() {

		List<Map> customersList = new ArrayList<Map>();

		Map<String, Object> r1 = new HashMap();
		r1.put("name", "John");
		r1.put("family", "Doe");
		r1.put("age", 15);

		Map<String, Object> r2 = new HashMap();
		r2.put("name", "Jane");
		r2.put("family", "Doe");
		r2.put("age", 35);

		customersList.add(r1);
		customersList.add(r2);

		return customersList;

	}

	public List<Map> getAllAccounts() {

		List<Map> accountList = new ArrayList<Map>();

		Map<String, Object> accountInfo = new HashMap<String, Object>();

		accountInfo.put("accountId", 10);
		accountInfo.put("type", 1);
		accountInfo.put("balance", 1500.98);
		accountInfo.put("customerId", 1);
		accountInfo.put("label", "Checking 1");
		accountInfo.put("branchId", 850);

		accountList.add(accountInfo);

		Map<String, Object> accountInfo_2 = new HashMap<String, Object>();

		accountInfo_2.put("accountId", 16);
		accountInfo_2.put("type", 2);
		accountInfo_2.put("balance", 68000.51);
		accountInfo_2.put("customerId", 2);
		accountInfo_2.put("label", "Saving 1");
		accountInfo_2.put("branchId", 150);

		accountList.add(accountInfo_2);

		return accountList;
	}

	public List<Map> getCustomerInfo() {
		List<Map> customersList = new ArrayList<Map>();

		Map<String, Object> r1 = new HashMap();
		r1.put("name", "John");
		r1.put("family", "Doe");
		r1.put("age", 15);
		r1.put("id", 1);

		customersList.add(r1);

		return customersList;

	}

}
