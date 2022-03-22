package com.co.gocho.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
