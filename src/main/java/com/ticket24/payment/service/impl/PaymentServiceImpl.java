package com.ticket24.payment.service.impl;

import com.ticket24.payment.dto.PaymentDto;
import com.ticket24.payment.entity.PaymentRequestEntity;
import com.ticket24.payment.mapper.PaymentRequestMapper;
import com.ticket24.payment.repository.PaymentRepository;
import com.ticket24.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private PaymentRequestMapper paymentRequestMapper = new PaymentRequestMapper();

    @Override
    public List<PaymentDto> getAll() {
        return paymentRepository.findAll().stream()
                .map(paymentRequestMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PaymentDto save(PaymentDto paymentDto) {
        PaymentRequestEntity paymentRequestEntity = paymentRepository.save(paymentRequestMapper.toEntity(paymentDto));
        return paymentRequestMapper.toDto(paymentRequestEntity);
    }
}
