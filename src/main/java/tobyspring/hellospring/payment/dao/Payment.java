package tobyspring.hellospring.payment.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
    private Long orderId;       // 주문 번호

    private String currency;    // 현재 통화

    private BigDecimal foreignCurrencyAmount;   // 정확한 소수점 계산을 위해서 double float 대신 bigdecimal 사용

    private BigDecimal exRate;      // 환율

    private BigDecimal convertedAmount;     // 환산 금액

    private LocalDateTime validUntil;      // 유효시간

    public Payment() {
    }

    public Payment(Long orderId, String currency, BigDecimal foreignCurrencyAmount, BigDecimal exRate, BigDecimal convertedAmount, LocalDateTime validUntil) {
        this.orderId = orderId;
        this.currency = currency;
        this.foreignCurrencyAmount = foreignCurrencyAmount;
        this.exRate = exRate;
        this.convertedAmount = convertedAmount;
        this.validUntil = validUntil;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId=" + orderId +
                ", currency='" + currency + '\'' +
                ", foreignCurrencyAmount=" + foreignCurrencyAmount +
                ", exRate=" + exRate +
                ", convertedAmount=" + convertedAmount +
                ", validUntil=" + validUntil +
                '}';
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getForeignCurrencyAmount() {
        return foreignCurrencyAmount;
    }

    public BigDecimal getExRate() {
        return exRate;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }
}
