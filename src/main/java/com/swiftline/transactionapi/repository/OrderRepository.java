package com.swiftline.transactionapi.repository;

import com.swiftline.transactionapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
