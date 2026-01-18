package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.OrderEntity;
import com.ecommerce.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private  InventoryService inventoryService;
	
	 @PostMapping("/reduce")
	    public Boolean reduceStock(@RequestBody OrderEntity order) {
		 
		 return inventoryService.reduceStock(order);
	 }

}
