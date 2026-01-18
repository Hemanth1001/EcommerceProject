package com.ecommerce.service;

import com.ecommerce.entity.OrderEntity;

public interface InventoryService {

	public Boolean reduceStock(OrderEntity order);
}
