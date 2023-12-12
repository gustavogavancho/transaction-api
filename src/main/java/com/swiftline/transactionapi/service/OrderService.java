package com.swiftline.transactionapi.service;

import com.swiftline.transactionapi.payload.OrderRequest;
import com.swiftline.transactionapi.payload.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);
}
