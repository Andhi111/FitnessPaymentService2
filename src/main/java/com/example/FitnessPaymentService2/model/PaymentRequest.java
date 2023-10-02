package com.example.FitnessPaymentService2.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class PaymentRequest {
    private String creditCardNumber;
    private String cvv;
    private String cardHolderName;
    private BigDecimal amount;

    // Constructors, getters, and setters

    public PaymentRequest() {
        // Default constructor
    }
}
