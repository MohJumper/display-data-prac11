package com.codercampus.Assignment11.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.codercampus.Assignment11.domain.Transaction;

@Repository
public class TransactionRepository {
	private List<Transaction> transactions = new ArrayList<>(100);
	
	public TransactionRepository () {
		super();
		populateData();
	}
	
	// how to sort locatedatetime? java 8 already implement Comparable so you just need to call them
		// found this here https://stackoverflow.com/questions/32625407/sorting-localdatetime
//	public List<Transaction> findAll () {
//		List<Transaction> sortedTransactions = transactions.stream()
//											   .sorted(Comparator.comparing(Transaction::getDate).reversed())
//											   .collect(Collectors.toList());
//		return sortedTransactions;
//		
//	}
	// remember to implement Comparable<Transaction> on the entity using the date attribute
	public List<Transaction> findAll() {
		Collections.sort(transactions);
		return transactions;
	}

	// return transaction.getId().equals(transactionId) ? transaction : null;
	public Transaction findById(long transactionId) {
		for (Transaction transaction : transactions) {
			if (transaction.getId().equals(transactionId)) {
				return transaction;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private void populateData() {
		try (FileInputStream fileInputStream = new FileInputStream("transactions.txt");
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
			this.transactions = (List<Transaction>) objectInputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
