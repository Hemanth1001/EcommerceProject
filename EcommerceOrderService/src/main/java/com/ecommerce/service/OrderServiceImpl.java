package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.dto.OrderRequest;
import com.ecommerce.entity.OrderEntity;
import com.ecommerce.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	
	@Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

	@Override
	public String placeOrder(OrderRequest request) {
		// TODO Auto-generated method stub
		OrderEntity order = new OrderEntity();
        order.setProductId(request.getProductId());
        order.setQuantity(request.getQuantity());
        order.setTotalAmount(request.getPrice() * request.getQuantity());

        orderRepository.save(order);

        String paymentStatus = restTemplate.postForObject(
                "http://localhost:8085/payments",
                request,
                String.class
        );

        if ("SUCCESS".equals(paymentStatus)) {
            order.setStatus(OrderStatus.PAID);
            orderRepository.save(order);
            return "ORDER PLACED SUCCESSFULLY";
        }

        order.setStatus(OrderStatus.FAILED);
        orderRepository.save(order);
        return "ORDER FAILED";
		
	}

}
