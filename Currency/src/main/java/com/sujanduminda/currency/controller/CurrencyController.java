package com.sujanduminda.currency.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    private static final Map<String, Double> RATES = Map.of(
            "USD:EUR", 0.92,
            "EUR:USD", 1.09,
            "USD:GBP", 0.78,
            "GBP:USD", 1.28
    );

    @GetMapping("/exchange")
    public ResponseEntity<Map<String, Object>> exchange(@RequestParam String from, @RequestParam String to) {
        String key = from.toUpperCase() + ":" + to.toUpperCase();
        Double rate = RATES.get(key);
        if (rate == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Rate not found for " + key));
        }
        return ResponseEntity.ok(Map.of(
                "from", from.toUpperCase(),
                "to", to.toUpperCase(),
                "rate", rate
        ));
    }
}
