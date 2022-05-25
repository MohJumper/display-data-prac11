package com.codercampus.Assignment11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transcationRepo;
	
	
	public List<Transaction> findAll(){
//		System.out.println("here from service");
		return transcationRepo.findAll();
	}


	public Transaction findById(Integer transactionId) {
		
		return transcationRepo.findById(transactionId);
	}

}
