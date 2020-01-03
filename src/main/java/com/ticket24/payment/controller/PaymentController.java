package com.ticket24.payment.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.ticket24.payment.dto.OrderDto;
import com.ticket24.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
@ControllerAdvice
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    //TODO getOrders() only for testing purpose. Should be removed.
    @GetMapping("/all")
    public List<OrderDto> getAllOrders() {
        return paymentService.getAll();
    }

    @GetMapping("/{id}")
    public OrderDto getOrder(@PathVariable long id) {
        return paymentService.getById(id);
    }

    @GetMapping("/{id}/status")
    public String getOrderStatus(@PathVariable long id) {
        // toString for getting status without ""
        return paymentService.getOrderStatusById(id).toString();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long createOrder(@Valid @RequestBody OrderDto orderDto) {
        return paymentService.save(orderDto).getId();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidFormatException.class)
    public String typeMismatchException(
            HttpServletRequest request, HttpServletResponse servletResponse, InvalidFormatException e) {
        return "Invalid format";
    }
}