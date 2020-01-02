package com.ticket24.payment.entity;

import com.ticket24.payment.enums.RequestStatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Date dateToGo;
    private Integer routeNumber;
    private RequestStatusType status;

}
