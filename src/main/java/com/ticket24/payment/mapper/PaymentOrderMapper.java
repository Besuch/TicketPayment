package com.ticket24.payment.mapper;

import com.ticket24.payment.dto.OrderDto;
import com.ticket24.payment.entity.OrderEntity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PaymentOrderMapper {

    public OrderDto toDto(OrderEntity orderEntity) {
        return OrderDto.builder()
                .id(orderEntity.getId())
                .routeNumber(orderEntity.getRouteNumber())
                .dateToGo(orderEntity.getDateToGo())
                .status(orderEntity.getStatus())
                .build();
    }

    public OrderEntity toEntity(OrderDto orderDto) {
        return OrderEntity.builder()
                .routeNumber(orderDto.getRouteNumber())
                .dateToGo(orderDto.getDateToGo())
                .status(orderDto.getStatus())
                .build();
    }
}
