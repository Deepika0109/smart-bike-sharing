package com.example.payment.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @PostMapping
    public Map<String, String> pay(@RequestBody Map<String, Object> body) {
        // simulate payment processing
        return Map.of("status", "success", "transactionId", "tx12345");
    }
}