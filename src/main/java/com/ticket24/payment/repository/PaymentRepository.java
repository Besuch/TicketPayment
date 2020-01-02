package com.ticket24.payment.repository;

import com.ticket24.payment.entity.PaymentRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentRequestEntity, Long> {
}
