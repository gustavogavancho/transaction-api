package com.swiftline.transactionapi.service.impl;

import com.swiftline.transactionapi.exception.PaymentException;
import com.swiftline.transactionapi.payload.OrderRequest;
import com.swiftline.transactionapi.payload.OrderResponse;
import com.swiftline.transactionapi.repository.OrderRepository;
import com.swiftline.transactionapi.repository.PaymentRepository;
import com.swiftline.transactionapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        var order = orderRequest.getOrder();
        order.setStatus("IN PROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        var payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")) {

            throw new PaymentException("Payment card type is not supported");
        }

        payment.setOderId(order.getId());
        paymentRepository.save(payment);

        var orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;
    }
}
