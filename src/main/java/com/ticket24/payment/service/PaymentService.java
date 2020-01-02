package com.ticket24.payment.service;

import com.ticket24.payment.dto.PaymentDto;

import java.util.List;

public interface PaymentService {
    List<PaymentDto> getAll();
    PaymentDto save(PaymentDto paymentDto);
}
