package com.picpay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import com.picpay.DTOs.TransactionDTO;
import com.picpay.domain.Transaction.Transaction;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picpay.DTOs.TransactionDTO;
import com.picpay.DTOs.UserDTO;
import com.picpay.domain.Transaction.Transaction;
import com.picpay.domain.User.User;
import com.picpay.services.TransactionService;

@RestController
@RequestMapping("/transfer")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;
    
    @Operation(summary = "Create a new transaction", description = "Performs a financial transaction between two users.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Transaction successfully completed."),
        @ApiResponse(responseCode = "400", description = "Invalid transaction details."),
        @ApiResponse(responseCode = "500", description = "Transaction not authorized.")
    })	
	@PostMapping
	public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception {
		
		Transaction newTransaction = this.transactionService.createTransaction(transaction);
		return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
		
	}
	
	
}
