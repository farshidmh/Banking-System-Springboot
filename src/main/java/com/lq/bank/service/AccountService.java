package com.lq.bank.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lq.bank.data.AccountRepository;
import com.lq.bank.data.TransactionRepository;
import com.lq.bank.enums.AccountType;
import com.lq.bank.exception.AccountNotFoundException;
import com.lq.bank.model.Account;
import com.lq.bank.model.Branch;
import com.lq.bank.model.Customer;
import com.lq.bank.model.Transaction;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	public int calculateAccountBalance() {

		List<Transaction> transactionList = transactionRepository.findByAccountID(1);
		int balance = 0;
		for (Transaction t : transactionList) {

			if( t.isDeposit() ) {				
				balance += t.getAmount(); // balance = balance + x				
			}else {
				balance -= t.getAmount(); // balance = balance - x				
			}
				
		}

		return balance;
	}

	public Account getAccountById(int accountId) throws AccountNotFoundException {
		Optional<Account> acOptional = accountRepository.findById(accountId);
		if (acOptional.isEmpty()) {
			throw new AccountNotFoundException();
		}

		Account account = acOptional.get();
		return account;
	}

	public void createNewAccount(Branch branch, Customer customer, String label, AccountType type) {
		Account account = new Account(label, type, branch, customer);
		accountRepository.save(account);
	}

	public void deposit(Account account, int amount) {

		Timestamp currentTime = new Timestamp(System.currentTimeMillis());

		Transaction transaction = new Transaction(account, currentTime, amount);

		transactionRepository.save(transaction);

	}

	public void withdrawal(Account account, int amount) {

		Timestamp currentTime = new Timestamp(System.currentTimeMillis());

		Transaction transaction = new Transaction(account, currentTime, amount,false);

		transactionRepository.save(transaction);

	}

	public Map<String, Object> buildAccountInfo(Account account) {

		Map<String, Object> accountInfo = new HashMap<String, Object>();

		accountInfo.put("accountId", account.getId());
		accountInfo.put("type", account.getType());
		accountInfo.put("balance", 1500.98);
		accountInfo.put("customerId", account.getCustomer().getId());
		accountInfo.put("label", account.getLabel());
		accountInfo.put("branchId", account.getBranch().getBranchId());

		return accountInfo;
	}

	public List<Map> getAllAccounts() {
		List<Map> accountList = new ArrayList<Map>();

		return accountList;
	}

	public List<Map> getAccountInfo() {
		List<Map> accountList = new ArrayList<Map>();

		return accountList;
	}

}
