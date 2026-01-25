package com.example.bean_ambiguity.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service()
//@Primary
public class UpiPaymentService implements PaymentService{

    @Override
    public void pay() {
        System.out.println("Payment done using UPI");
    }
}
