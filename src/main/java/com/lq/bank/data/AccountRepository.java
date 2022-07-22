package com.lq.bank.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lq.bank.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account,Integer> {
	
	
	

}
