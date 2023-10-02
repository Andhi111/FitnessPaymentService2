package com.example.FitnessPaymentService2.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Service3Response {
    private String status;
    private String timestamp;

    public Service3Response() {
        // Default constructor
    }
    public Service3Response(String status, String timestamp) {
        this.status = status;
        this.timestamp = timestamp;
    }
}
