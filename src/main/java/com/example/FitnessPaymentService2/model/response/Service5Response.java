package com.example.FitnessPaymentService2.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Service5Response {
    private String status;
    private String timestamp;

    public Service5Response() {
        // Default constructor
    }
    public Service5Response(String status, String timestamp) {
        this.status = status;
        this.timestamp = timestamp;
    }
}
