package com.lq.bank.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lq.bank.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
	
	
	@Query( value="SELECT * FROM TRANSACTION where ACCOUNT_ID=?1 " , nativeQuery=true )
	List<Transaction> findByAccountID(int accountId);
	
	

}
