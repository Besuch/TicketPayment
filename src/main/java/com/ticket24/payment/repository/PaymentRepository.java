package com.ticket24.payment.repository;

import com.ticket24.payment.entity.OrderEntity;
import com.ticket24.payment.enums.OrderStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<OrderEntity, Long> {

    @Query("SELECT o FROM OrderEntity o WHERE o.status = :status")
    List<OrderEntity> findByStatusType(OrderStatusType status);
}