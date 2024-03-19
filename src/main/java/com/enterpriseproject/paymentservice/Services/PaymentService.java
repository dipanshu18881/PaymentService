package com.enterpriseproject.paymentservice.Services;

import com.razorpay.RazorpayException;

public interface PaymentService {
    String createPaymentLink(String orderId) throws RazorpayException;
    String getPaymentStatus(String paymentId);
}
