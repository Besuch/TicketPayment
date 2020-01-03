package com.ticket24.payment.dto;

import com.ticket24.payment.enums.OrderStatusType;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
public class OrderDto {

    private Long id;
    @NotNull
    private LocalDate dateToGo;
    @NotNull
    private Integer routeNumber;
    @NotNull
    private OrderStatusType status;

}
