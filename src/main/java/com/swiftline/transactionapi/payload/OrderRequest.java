package com.swiftline.transactionapi.payload;

import com.swiftline.transactionapi.entity.Order;
import com.swiftline.transactionapi.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

    private Order order;
    private Payment payment;
}
