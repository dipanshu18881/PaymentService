package com.enterpriseproject.paymentservice.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentLinkRequestDto {
    private String orderId;
}
