package com.swiftline.transactionapi.controller;

import com.swiftline.transactionapi.payload.OrderRequest;
import com.swiftline.transactionapi.payload.OrderResponse;
import com.swiftline.transactionapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("apu/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) {

        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }
}
