package com.example.FitnessPaymentService2.model;

import com.example.FitnessPaymentService2.model.response.Service3Response;
import com.example.FitnessPaymentService2.model.response.Service4Response;
import com.example.FitnessPaymentService2.model.response.Service5Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResponse {
    private String status;
    private String timestamp;
    private Service3Response service3Response;
    private Service4Response service4Response;
    private Service5Response service5Response;



    public PaymentResponse() {
    }

    public PaymentResponse(String status, String timestamp) {
        this.status = status;
        this.timestamp = timestamp;
    }
}
