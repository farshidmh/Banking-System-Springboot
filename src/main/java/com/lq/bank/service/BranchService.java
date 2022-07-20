package com.lq.bank.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lq.bank.model.Branch;

@Service
public class BranchService {

	public List<Map<String, Object>> getAllbranches() {

		List<Map<String, Object>> branchList = new ArrayList<Map<String, Object>>();

		Map<String, Object> branchInfo = new HashMap<String, Object>();

		Branch branchA = new Branch(1, "Branch A");

		branchInfo.put("name", branchA.getBranchName());
		branchInfo.put("branchId", branchA.getBranchId());

		Map<String, Object> branchInfo2 = new HashMap<String, Object>();

		Branch branchB = new Branch(2, "Branch B");

		branchInfo2.put("name", branchB.getBranchName());
		branchInfo2.put("branchId", branchB.getBranchId());

		branchList.add(branchInfo);
		branchList.add(branchInfo2);

		return branchList;

	}

}
