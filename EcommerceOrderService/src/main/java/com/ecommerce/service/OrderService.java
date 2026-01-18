package com.ecommerce.service;

import com.ecommerce.dto.OrderRequest;

public interface OrderService {
	
	public String placeOrder(OrderRequest request);

}
