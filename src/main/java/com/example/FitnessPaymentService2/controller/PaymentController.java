package com.example.FitnessPaymentService2.controller;

import com.example.FitnessPaymentService2.kafka.PaymentConsumer;
import com.example.FitnessPaymentService2.model.PaymentRequest;
import com.example.FitnessPaymentService2.model.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentConsumer paymentConsumer;

    @PostMapping("/process")
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = paymentConsumer.processPayment(paymentRequest);
        return ResponseEntity.ok(paymentResponse);
    }
}
