package com.lq.bank.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lq.bank.data.BranchRepository;
import com.lq.bank.exception.BranchNotFoundException;
import com.lq.bank.model.Branch;

@Service
public class BranchService {

	@Autowired
	private BranchRepository branchRepository;

	public void newBranch(String name) {
		Branch newBranch = new Branch(name);
		branchRepository.save(newBranch);
	}

	public Branch getBranchById(int branchId) throws BranchNotFoundException {
		Optional<Branch> branchOptional = branchRepository.findById(branchId);
		if (branchOptional.isEmpty()) {
			throw new BranchNotFoundException();
		}
		
		Branch tempBranch = branchOptional.get();
		return tempBranch;
	}

	public void updateBranch(String name, int branchId) {
		Optional<Branch> tempBranchOptional = branchRepository.findById(branchId);
		if (!tempBranchOptional.isEmpty()) {
			Branch tmp = tempBranchOptional.get();
			tmp.setBranchName(name);
			branchRepository.save(tmp);
		}
	}

	public List<Map> getSingleBranchInfo(int branchId) {
		Optional<Branch> temp = branchRepository.findById(branchId);
		List<Map> branchList = new ArrayList<Map>();
		if (!temp.isEmpty()) {
			branchList.add(buildBranchInfo(temp.get()));
		}
		return branchList;
	}

	public void deleteBranch(int branchId) {
		Optional<Branch> temp = branchRepository.findById(branchId);
		if (!temp.isEmpty()) {
			branchRepository.delete(temp.get());
		}
	}

	public Map buildBranchInfo(Branch branch) {
		Map<String, Object> branchInfo = new HashMap<String, Object>();
		branchInfo.put("name", branch.getBranchName());
		branchInfo.put("branchId", branch.getBranchId());
		return branchInfo;
	}

	public List<Map> getAllbranches() {
		List<Map> branchList = new ArrayList<Map>();
		Iterable<Branch> allBranches = branchRepository.findAll();
		for (Branch t : allBranches) {
			branchList.add(buildBranchInfo(t));
		}
		return branchList;
	}

}
