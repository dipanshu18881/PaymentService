package com.enterpriseproject.paymentservice.Controllers;

import com.enterpriseproject.paymentservice.DTOs.CreatePaymentLinkRequestDto;
import com.enterpriseproject.paymentservice.Services.PaymentService;
import com.fasterxml.jackson.core.JsonToken;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String createPaymentLink(@RequestBody CreatePaymentLinkRequestDto request) throws RazorpayException {
        String paymentlink = paymentService.createPaymentLink(request.getOrderId());
        return paymentlink;
    }

    @PostMapping("/webhook")
    public void handleWebhookEvent(@RequestBody JSONObject webhook) {
        System.out.println(webhook);
    }
}
