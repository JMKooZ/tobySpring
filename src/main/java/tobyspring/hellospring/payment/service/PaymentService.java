package tobyspring.hellospring.payment.service;

import tobyspring.hellospring.payment.dao.Payment;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

public class PaymentService {
    private final ExRateProvider exRateProvdier;
    private final Clock clock;

    public PaymentService(ExRateProvider exRateProvdier, Clock clock) {
        this.exRateProvdier = exRateProvdier;
        this.clock = clock;
    }

    public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) {
        BigDecimal exRate = exRateProvdier.getExRate(currency);

        return Payment.createdPrepared(orderId, currency, foreignCurrencyAmount, exRate, LocalDateTime.now(clock));
    }
}
