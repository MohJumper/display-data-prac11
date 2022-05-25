package com.codercampus.Assignment11.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class Practice11Controller {
	
	@Autowired
	private TransactionService transactionService;
	
	
	@GetMapping("/transactions")
	public String getTransaction(ModelMap model) {
		
//		Transaction transaction = new Transaction();
		
		List<Transaction> transactions = transactionService.findAll();
		
		model.put("transactions", transactions);
		
		return "transactions";
	}
	
	@GetMapping("/transactions/{transactionId}")
	public String getTransactionId(@PathVariable Integer transactionId, ModelMap model) {
		Transaction oneTransaction = transactionService.findById(transactionId);
					
		model.put("oneTransaction", oneTransaction);
		
		return "singletrans";
	}
	

}
