package com.lq.bank.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lq.bank.model.Branch;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Integer> {

	
	
	
}
