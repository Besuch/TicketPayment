package com.ticket24.payment;

import com.ticket24.payment.entity.OrderEntity;
import com.ticket24.payment.enums.OrderStatusType;
import com.ticket24.payment.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;

@EnableScheduling
@SpringBootApplication
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(PaymentRepository paymentRepository) {
        LocalDate date = LocalDate.of(2020, 2, 12);
        return (String[] args) -> {

            OrderEntity firstOrderEntity = OrderEntity.builder()
                    .routeNumber(101)
                    .dateToGo(date)
                    .status(OrderStatusType.COMPLETE)
                    .build();

            OrderEntity secondOrderEntity = OrderEntity.builder()
                    .routeNumber(105)
                    .dateToGo(date)
                    .status(OrderStatusType.ERROR)
                    .build();

            paymentRepository.save(firstOrderEntity);
            paymentRepository.save(secondOrderEntity);
        };
    }
}
