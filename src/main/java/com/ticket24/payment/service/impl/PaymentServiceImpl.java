package com.ticket24.payment.service.impl;

import com.ticket24.payment.dto.OrderDto;
import com.ticket24.payment.entity.OrderEntity;
import com.ticket24.payment.enums.OrderStatusType;
import com.ticket24.payment.mapper.PaymentOrderMapper;
import com.ticket24.payment.repository.PaymentRepository;
import com.ticket24.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private PaymentOrderMapper paymentOrderMapper = new PaymentOrderMapper();

    @Override
    public List<OrderDto> getAll() {
        return paymentRepository.findAll().stream()
                .map(paymentOrderMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        OrderEntity orderEntity = paymentRepository.save(paymentOrderMapper.toEntity(orderDto));
        return paymentOrderMapper.toDto(orderEntity);
    }

    @Override
    public OrderDto getById(long id) {
        Optional<OrderEntity> order = paymentRepository.findById(id);
        if (order.isPresent()) {
            return paymentOrderMapper.toDto(order.get());
        }
        throw new RuntimeException("Order with id:" + id + " Not found");
    }

    public OrderStatusType getOrderStatusById(long id) {
        Optional<OrderEntity> order = paymentRepository.findById(id);
        if (order.isPresent()) {
            return order.get().getStatus();
        }
        throw new RuntimeException("Order with id:" + id + " Not found");
    }
}
