package com.swiftline.transactionapi.repository;

import com.swiftline.transactionapi.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
