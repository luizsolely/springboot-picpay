package com.picpay.DTOs;

import java.math.BigDecimal;

import com.picpay.domain.User.UserType;

public record UserDTO(
	
		String firstName,
		String lastName,
		String document,
		BigDecimal balance,
		String email,
		String password,
		UserType userType
		
) { }
