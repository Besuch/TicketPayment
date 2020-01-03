package com.ticket24.payment.mapper;

import com.ticket24.payment.dto.OrderDto;
import com.ticket24.payment.entity.OrderEntity;
import com.ticket24.payment.enums.OrderStatusType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PaymentOrderMapperTest {

    private PaymentOrderMapper paymentOrderMapper = new PaymentOrderMapper();

    private OrderEntity orderEntity;
    private OrderDto orderDto;

    @BeforeEach
    void setUp() {
        orderEntity = OrderEntity.builder()
                .id(1L)
                .routeNumber(101)
                .dateToGo(LocalDate.of(2020, 2, 12))
                .status(OrderStatusType.COMPLETE)
                .build();

        orderDto = OrderDto.builder()
                .id(1L)
                .routeNumber(101)
                .dateToGo(LocalDate.of(2020, 2, 12))
                .status(OrderStatusType.COMPLETE)
                .build();
    }

    @Test
    void toDto() {
        OrderDto expectedOrderDto = OrderDto.builder()
                .id(1L)
                .routeNumber(101)
                .dateToGo(LocalDate.of(2020, 2, 12))
                .status(OrderStatusType.COMPLETE)
                .build();

        OrderDto actualOrderDto = paymentOrderMapper.toDto(orderEntity);

        assertEquals(expectedOrderDto, actualOrderDto);
    }

    @Test
    void toEntity() {
        OrderEntity expectedOrderEntity = OrderEntity.builder()
                .routeNumber(101)
                .dateToGo(LocalDate.of(2020, 2, 12))
                .status(OrderStatusType.COMPLETE)
                .build();

        OrderEntity actualOrderEntity = paymentOrderMapper.toEntity(orderDto);

        assertEquals(expectedOrderEntity, actualOrderEntity);
    }
}