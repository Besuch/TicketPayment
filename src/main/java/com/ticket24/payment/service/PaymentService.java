package com.ticket24.payment.service;

import com.ticket24.payment.dto.OrderDto;
import com.ticket24.payment.enums.OrderStatusType;

import java.util.List;

public interface PaymentService {
    List<OrderDto> getAll();

    OrderDto save(OrderDto orderDto);

    OrderDto getById(long id);

    OrderStatusType getOrderStatusById(long id);
}
