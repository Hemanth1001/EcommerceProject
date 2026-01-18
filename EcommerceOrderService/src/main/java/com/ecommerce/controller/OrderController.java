package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.OrderRequest;
import com.ecommerce.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	

	@Autowired
	private OrderService orderService;
	
    
    @PostMapping
    public String placeOrder(@RequestBody OrderRequest request) {
    	 String placeOrder = orderService.placeOrder(request);	 
    	 return placeOrder;
    }
}

