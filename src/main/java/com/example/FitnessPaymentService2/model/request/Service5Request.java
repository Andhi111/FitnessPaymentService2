package com.example.FitnessPaymentService2.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Service5Request {
    private String cardNUmber;
    private String cardHolderName;

    public Service5Request(String cardNUmber, String cardHolderName) {
        this.cardNUmber = cardNUmber;
        this.cardHolderName = cardHolderName;
    }
}
