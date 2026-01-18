package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.dto.OrderRequest;
import com.ecommerce.entity.PaymentEntity;
import com.ecommerce.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PaymentRepository paymentRepository;
	
	@Override
	public String processPayment(OrderRequest order) {
		
		Boolean stockAvailable = restTemplate.postForObject(
                "http://localhost:8084/inventory/reduce",
                order,
                Boolean.class
        );
		
		PaymentEntity payment = new PaymentEntity();
        payment.setOrderId(null);
        payment.setAmount(order.getPrice() * order.getQuantity());
        
        
        if (Boolean.TRUE.equals(stockAvailable)) {
            payment.setStatus(PaymentStatus.SUCCESS);
            paymentRepository.save(payment);
            return "SUCCESS";
        }
        
        
        payment.setStatus(PaymentStatus.FAILED);
        paymentRepository.save(payment);
        return "FAILED";
        		
	}

}
