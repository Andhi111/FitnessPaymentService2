package com.example.FitnessPaymentService2.model.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Service3Request {
    private String cardNumber;
    private BigDecimal amount;

    public Service3Request(String cardNumber, BigDecimal amount) {
        this.cardNumber = cardNumber;
        this.amount = amount;
    }
}
