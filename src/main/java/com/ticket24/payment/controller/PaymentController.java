package com.ticket24.payment.controller;

import com.ticket24.payment.entity.Ticket;
import com.ticket24.payment.repository.TicketRepository;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
public class PaymentController {

    private final TicketRepository ticketRepository;

    @GetMapping("tickets")
    public List<Ticket> doGet(@RequestParam(required = false, defaultValue = "0") Integer page) {
        return ticketRepository.findAll(PageRequest.of(page, 5)).getContent();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String haveException() {
        return "Wrong page argument";
    }
}
