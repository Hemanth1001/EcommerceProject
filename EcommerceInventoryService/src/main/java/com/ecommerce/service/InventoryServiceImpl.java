package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.InventoryEntity;
import com.ecommerce.entity.OrderEntity;
import com.ecommerce.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
    private InventoryRepository inventoryRepository;

	@Override
	public Boolean reduceStock(OrderEntity order) {
		InventoryEntity inventory = inventoryRepository
                .findByProductId(order.getProductId())
                .orElseGet(() -> {
                    InventoryEntity inv = new InventoryEntity();
                    inv.setProductId(order.getProductId());
                    inv.setAvailableQuantity(10);
                    return inventoryRepository.save(inv);
                });

        if (inventory.getAvailableQuantity() >= order.getQuantity()) {
            inventory.setAvailableQuantity(
                    inventory.getAvailableQuantity() - order.getQuantity());
            inventoryRepository.save(inventory);
            return true;
        }
        return false;
	}

}
