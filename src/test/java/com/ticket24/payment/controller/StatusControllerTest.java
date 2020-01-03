package com.ticket24.payment.controller;

import com.ticket24.payment.enums.OrderStatusType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

class StatusControllerTest {

    private StatusController statusController = new StatusController();

    @Test
    void getRandomStatus() {
        Random random = new Random();
        OrderStatusType[] statuses = OrderStatusType.values();
        int nextInt = random.nextInt(statuses.length);

        String expected = statuses[nextInt].toString();

        String actual = statusController.getRandomStatus();

        assertEquals(expected, actual);
    }
}