package com.example.FitnessPaymentService2.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Service4Request {
    private String cardNumber;
    private String cvv;

    public Service4Request(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }
}
