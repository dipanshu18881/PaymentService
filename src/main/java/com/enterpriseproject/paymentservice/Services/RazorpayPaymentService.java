package com.enterpriseproject.paymentservice.Services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RazorpayPaymentService implements PaymentService{

    private RazorpayClient razorpayClient;

    public RazorpayPaymentService(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String createPaymentLink(String orderId) throws RazorpayException {

        JSONObject paymentLinkRequest = new JSONObject();

        paymentLinkRequest.put("amount",1000);  //  10.00
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",false);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by", System.currentTimeMillis() + 900000);   // "1691097057" EPOCH timestamp
        paymentLinkRequest.put("reference_id", orderId);    //  "TS1989"
        paymentLinkRequest.put("description","Payment for order no " + orderId);


        JSONObject customer = new JSONObject();

        customer.put("name","Dipanshu");
        customer.put("contact","+919667106700");
        customer.put("email","dipanshu18881@gmail.com");
        paymentLinkRequest.put("customer",customer);


        JSONObject notify = new JSONObject();

        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("reminder_enable",true);


        JSONObject notes = new JSONObject();

        notes.put("Order Items","1. iPhone 15 Pro Max");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://google.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);

        return payment.get("short_url");
    }

    @Override
    public String getPaymentStatus(String paymentId) {
        return null;
    }
}
