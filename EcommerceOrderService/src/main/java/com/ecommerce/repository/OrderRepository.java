package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
