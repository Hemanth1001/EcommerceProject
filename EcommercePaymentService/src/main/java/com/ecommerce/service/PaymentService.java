package com.ecommerce.service;

import com.ecommerce.dto.OrderRequest;

public interface PaymentService {
	
	 public String processPayment(OrderRequest order);

}
