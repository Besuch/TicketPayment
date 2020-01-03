package com.ticket24.payment.service.impl;

import com.ticket24.payment.dto.OrderDto;
import com.ticket24.payment.entity.OrderEntity;
import com.ticket24.payment.enums.OrderStatusType;
import com.ticket24.payment.mapper.PaymentOrderMapper;
import com.ticket24.payment.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentServiceImplTest {

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private PaymentOrderMapper paymentOrderMapper;

    private OrderEntity orderEntity1;
    private OrderEntity orderEntity2;
    private OrderDto orderDto1;
    private OrderDto orderDto2;

    private List<OrderEntity> orderEntities;
    private List<OrderDto> orderDtos;

    @BeforeEach
    void setUp() {
        orderEntity1 = OrderEntity.builder()
                .routeNumber(101)
                .dateToGo(LocalDate.of(2020, 2, 12))
                .status(OrderStatusType.COMPLETE)
                .build();

        orderEntity2 = OrderEntity.builder()
                .routeNumber(202)
                .dateToGo(LocalDate.of(2020, 2, 12))
                .status(OrderStatusType.ERROR)
                .build();
        orderEntities = Arrays.asList(orderEntity1, orderEntity2);

        orderDto1 = OrderDto.builder()
                .routeNumber(101)
                .dateToGo(LocalDate.of(2020, 2, 12))
                .status(OrderStatusType.COMPLETE)
                .build();

        orderDto2 = OrderDto.builder()
                .routeNumber(202)
                .dateToGo(LocalDate.of(2020, 2, 12))
                .status(OrderStatusType.ERROR)
                .build();
        orderDtos = Arrays.asList(orderDto1, orderDto2);
    }

    @Test
    void getAll() {
        when(paymentRepository.findAll()).thenReturn(orderEntities);

        List<OrderDto> actual = paymentService.getAll();

        assertEquals(orderDtos, actual);
    }

    @Test
    void save() {
        when(paymentRepository.save(orderEntity1)).thenReturn(orderEntity1);

        OrderDto actual = paymentService.save(orderDto1);

        assertEquals(orderDto1, actual);
    }

    @Test
    void getById() {
        long id = 1L;
        Optional<OrderEntity> order = Optional.of(orderEntity1);

        when(paymentRepository.findById(id)).thenReturn(order);

        OrderDto actual = paymentService.getById(id);

        assertEquals(orderDto1, actual);
    }

    @Test
    void getOrderStatusById() {
        long id = 2L;
        Optional<OrderEntity> order = Optional.of(orderEntity2);

        when(paymentRepository.findById(id)).thenReturn(order);

        OrderStatusType expectedStatus = order.get().getStatus();
        OrderStatusType actualStatus = paymentService.getOrderStatusById(id);

        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    void getOrderByWrongId() {
        Exception exception = assertThrows(
                RuntimeException.class,
                () -> paymentService.getById(5L));

        assertEquals("Order with id:" + 5 + " Not found", exception.getMessage());
    }

    @Test
    void getOrderStatusByWrongId() {
        Exception exception = assertThrows(
                RuntimeException.class,
                () -> paymentService.getOrderStatusById(5L));

        assertEquals("Order with id:" + 5 + " Not found", exception.getMessage());
    }
}