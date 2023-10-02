package com.example.FitnessPaymentService2.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Service4Response {
    private String status;
    private String timestamp;

    public Service4Response() {
        // Default constructor
    }
    public Service4Response(String status, String timestamp) {
        this.status = status;
        this.timestamp = timestamp;
    }
}
