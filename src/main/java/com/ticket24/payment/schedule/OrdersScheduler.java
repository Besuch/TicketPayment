package com.ticket24.payment.schedule;

import com.ticket24.payment.entity.OrderEntity;
import com.ticket24.payment.enums.OrderStatusType;
import com.ticket24.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrdersScheduler {

    private final PaymentRepository paymentRepository;
    private RestTemplate restTemplate = new RestTemplate();

    @Scheduled(cron = "${orders.scheduler.cron}")
    public void run() {
        log.info("Start Order Scheduler");
        List<OrderEntity> orders = getOrdersByStatusInProgress();
        orders.forEach(e -> e.setStatus(getRandomStatus()));
        paymentRepository.saveAll(orders);
        log.info("Updated " + orders.size() + " orders");
        log.info("Finish Order Scheduler");
    }

    private OrderStatusType getRandomStatus() {
        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("http://localhost:8080/statusGenerator", String.class);
        return OrderStatusType.valueOf(responseEntity.getBody());
    }

    private List<OrderEntity> getOrdersByStatusInProgress() {
        return paymentRepository.findByStatusType(OrderStatusType.IN_PROGRESS);
    }
}