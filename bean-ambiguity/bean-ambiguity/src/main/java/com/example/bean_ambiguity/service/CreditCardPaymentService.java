package com.example.bean_ambiguity.service;

import org.springframework.stereotype.Service;

@Service
public class CreditCardPaymentService implements PaymentService{

    @Override
    public void pay() {
        System.out.println("Payment done using Credit Card");
    }
}
