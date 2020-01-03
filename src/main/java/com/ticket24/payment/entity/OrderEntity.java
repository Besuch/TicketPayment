package com.ticket24.payment.entity;

import com.ticket24.payment.enums.OrderStatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate dateToGo;
    private Integer routeNumber;
    private OrderStatusType status;
}