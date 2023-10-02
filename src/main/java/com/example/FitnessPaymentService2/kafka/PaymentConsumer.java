package com.example.FitnessPaymentService2.kafka;

import com.example.FitnessPaymentService2.model.PaymentRequest;
import com.example.FitnessPaymentService2.model.PaymentResponse;
import com.example.FitnessPaymentService2.model.request.Service3Request;
import com.example.FitnessPaymentService2.model.request.Service4Request;
import com.example.FitnessPaymentService2.model.request.Service5Request;
import com.example.FitnessPaymentService2.model.response.Service3Response;
import com.example.FitnessPaymentService2.model.response.Service4Response;
import com.example.FitnessPaymentService2.model.response.Service5Response;
import com.example.FitnessPaymentService2.service.PaymentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentConsumer {
    @Autowired
    private PaymentProcessor paymentProcessor;
    @Autowired
    private KafkaTemplate<String, PaymentResponse> kafkaTemplate;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service3.url}")
    private String service3Url;

    @Value("${service4.url}")
    private String service4Url;

    @Value("${service5.url}")
    private String service5Url;

    @KafkaListener(topics = "${kafka.topic.payment}")

    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = paymentProcessor.processPayment(paymentRequest);

        ResponseEntity<Service3Response> service3ResponseEntity = restTemplate.postForEntity(
                service3Url + "/process-payment",
                new Service3Request(paymentRequest.getCreditCardNumber(), paymentRequest.getAmount()),
                Service3Response.class
        );
        Service3Response service3Response = service3ResponseEntity.getBody();

        ResponseEntity<Service4Response> service4ResponseEntity = restTemplate.postForEntity(
                service4Url + "/process-payment",
                new Service4Request(paymentRequest.getCreditCardNumber(), paymentRequest.getCvv()),
                Service4Response.class
        );
        Service4Response service4Response = service4ResponseEntity.getBody();

        ResponseEntity<Service5Response> service5ResponseEntity = restTemplate.postForEntity(
                service5Url + "/process-payment",
                new Service5Request(paymentRequest.getCreditCardNumber(), paymentRequest.getCardHolderName()),
                Service5Response.class
        );
        Service5Response service5Response = service5ResponseEntity.getBody();

        PaymentResponse paymentResponse1 = new PaymentResponse();
        paymentResponse1.setService3Response(service3Response);
        paymentResponse1.setService4Response(service4Response);
        paymentResponse1.setService5Response(service5Response);

        sendPaymentNotification("/topic/payment", paymentResponse);

        sendPaymentResponse("service1.payment.response", paymentResponse);

        return paymentResponse;

    }

    private void sendPaymentNotification(String destination, PaymentResponse paymentResponse) {
        messagingTemplate.convertAndSend(destination, paymentResponse);
    }

    private void sendPaymentResponse(String topic, PaymentResponse paymentResponse) {
        kafkaTemplate.send(topic, paymentResponse);
    }
}
