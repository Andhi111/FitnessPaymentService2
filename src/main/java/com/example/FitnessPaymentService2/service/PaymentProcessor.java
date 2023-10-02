package com.example.FitnessPaymentService2.service;

import com.example.FitnessPaymentService2.model.PaymentRequest;
import com.example.FitnessPaymentService2.model.PaymentResponse;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PaymentProcessor {
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {

        Instant processingEndTime = Instant.now();
        String formattedTimestamp = processingEndTime.toString();

        return new PaymentResponse("SUCCESS", formattedTimestamp);
    }
}
