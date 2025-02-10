package com.picpay.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.picpay.DTOs.TransactionDTO;
import com.picpay.domain.Transaction.Transaction;
import com.picpay.domain.Transaction.TransactionRepository;
import com.picpay.domain.User.User;

@Service
public class TransactionService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TransactionRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Transactional
	public Transaction createTransaction(TransactionDTO transaction) throws Exception {
		
		User sender = this.userService.findUserById(transaction.sender_id());
		User receiver = this.userService.findUserById(transaction.receiver_id());
		
		userService.validateTransaction(sender, transaction.value());
			
		boolean isAuthorized = this.authorizeTransaction(sender, transaction.value());
		
		if(!isAuthorized) {
			
			throw new Exception("Transação não autorizada.");
			
		}
		
		Transaction newTransaction = new Transaction();
		
		newTransaction.setAmount(transaction.value());
		newTransaction.setSender(sender);
		newTransaction.setReceiver(receiver);
		newTransaction.setTimestamp(LocalDateTime.now());
		
		updateBalances(sender, receiver, transaction.value());
		
		this.repository.save(newTransaction);
		userService.saveUser(sender);
		userService.saveUser(receiver);
		
		return newTransaction;
		
	}
	
	private void updateBalances(User sender, User receiver, BigDecimal value) {
        sender.setBalance(sender.getBalance().subtract(value));
        receiver.setBalance(receiver.getBalance().add(value));
        userService.saveUser(sender);
        userService.saveUser(receiver);
    }
	
	public boolean authorizeTransaction(User sender, BigDecimal value) {
	    try {
	        ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);

	        if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
	            Map<String, Object> body = authorizationResponse.getBody();
	            if (body != null && body.containsKey("data")) {
	                Map<String, Object> data = (Map<String, Object>) body.get("data");
	                return Boolean.TRUE.equals(data.get("authorization"));
	            }
	        }
	    } catch (Exception e) {
	        System.err.println("Erro ao consultar API de autorização: " + e.getMessage());
	    }
	    return false;
	}

	
}
