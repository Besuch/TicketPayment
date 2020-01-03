package com.ticket24.payment.controller;

import com.ticket24.payment.dto.OrderDto;
import com.ticket24.payment.enums.OrderStatusType;
import com.ticket24.payment.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentControllerTest {

    @InjectMocks
    private PaymentController paymentController;
    @Mock
    private PaymentService paymentService;

    private long id;
    private OrderDto orderDto;
    private List<OrderDto> orderDtos;

    @BeforeEach
    void setUp() {
        id = 1L;
        orderDto = OrderDto.builder()
                .id(id)
                .routeNumber(101)
                .dateToGo(LocalDate.of(2020, 2, 12))
                .status(OrderStatusType.COMPLETE)
                .build();

        orderDtos = Collections.singletonList(orderDto);
    }

    @Test
    void getAllOrders() {
        when(paymentService.getAll()).thenReturn(orderDtos);

        List<OrderDto> actual = paymentController.getAllOrders();

        assertEquals(orderDtos, actual);
    }

    @Test
    void getOrder() {
        when(paymentService.getById(id)).thenReturn(orderDto);

        OrderDto actualOrderDto = paymentController.getOrder(id);

        assertEquals(orderDto, actualOrderDto);
    }

    @Test
    void getOrderStatus() {
        OrderStatusType status = OrderStatusType.COMPLETE;
        when(paymentService.getOrderStatusById(id)).thenReturn(status);

        String expected = status.toString();
        String actualStatus = paymentController.getOrderStatus(id);

        assertEquals(expected, actualStatus);
    }

    @Test
    void createOrder() {
        when(paymentService.save(orderDto)).thenReturn(orderDto);

        long actualId = paymentController.createOrder(orderDto);

        assertEquals(id, actualId);
    }
}