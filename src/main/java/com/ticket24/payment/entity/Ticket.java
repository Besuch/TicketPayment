package com.ticket24.payment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;
    private String dateToGo;
    private Integer routeNumber;

    public Ticket() {
    }

    public Ticket(String dateToGo, Integer routeNumber) {
        this.dateToGo = dateToGo;
        this.routeNumber = routeNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateToGo() {
        return dateToGo;
    }

    public void setDateToGo(String dateToGo) {
        this.dateToGo = dateToGo;
    }

    public Integer getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(Integer routeNumber) {
        this.routeNumber = routeNumber;
    }
}
