package com.picpay.DTOs;

import java.math.BigDecimal;

public record TransactionDTO(
		
		BigDecimal value,
		Long sender_id,
		Long receiver_id
		
) { }
