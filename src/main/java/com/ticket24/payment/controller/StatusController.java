package com.ticket24.payment.controller;

import com.ticket24.payment.enums.OrderStatusType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/statusGenerator")
@ControllerAdvice
@RequiredArgsConstructor
public class StatusController {

    @GetMapping
    public String getRandomStatus() {
        Random random = new Random();
        OrderStatusType[] statuses = OrderStatusType.values();
        return statuses[random.nextInt(statuses.length)].toString();
    }
}