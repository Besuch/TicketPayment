package com.ticket24.payment.dto;

import com.ticket24.payment.enums.RequestStatusType;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class PaymentDto {

    private Long id;
    @NotNull
    private Date dateToGo;
    @NotNull
    private Integer routeNumber;
    @NotNull
    private RequestStatusType status;

}
