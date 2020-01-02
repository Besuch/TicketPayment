package com.ticket24.payment.mapper;

import com.ticket24.payment.dto.PaymentDto;
import com.ticket24.payment.entity.PaymentRequestEntity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PaymentRequestMapper {

    public PaymentDto toDto(PaymentRequestEntity paymentRequestEntity) {
        return PaymentDto.builder()
                .id(paymentRequestEntity.getId())
                .routeNumber(paymentRequestEntity.getRouteNumber())
                .dateToGo(paymentRequestEntity.getDateToGo())
                .status(paymentRequestEntity.getStatus())
                .build();
    }

    public PaymentRequestEntity toEntity(PaymentDto paymentDto) {
        return PaymentRequestEntity.builder()
                .routeNumber(paymentDto.getRouteNumber())
                .dateToGo(paymentDto.getDateToGo())
                .status(paymentDto.getStatus())
                .build();
    }
}
