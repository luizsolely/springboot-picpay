package com.picpay.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picpay.DTOs.UserDTO;
import com.picpay.domain.User.User;
import com.picpay.domain.User.UserType;
import com.picpay.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public void validateTransaction(User sender, BigDecimal amount) throws Exception {
		
		if(sender.getUserType() == UserType.MERCHANT) {			
			throw new Exception("Usuário não autorizado a realizar transações.");		
		}
		
		if(sender.getBalance().compareTo(amount) < 0) {			
			throw new Exception("Usuário não possui saldo suficiente para realizar a transação.");		
		}
		
	}
	
	public List<User> getAllUsers() {
		return this.repository.findAll();
	}
	
	public User findUserById(Long id) throws Exception {
		
		return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado."));
		
	}
	
	public User createUser(UserDTO data) {
		
		User newUser = new User(data);
		this.saveUser(newUser);
		
		return newUser;
		
	}
	
	public void saveUser(User user) {
		
		this.repository.save(user);
		
	}
	
}
