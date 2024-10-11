package tobyspring.hellospring.payment;

import tobyspring.hellospring.payment.dao.Payment;
import tobyspring.hellospring.payment.service.PaymentService;
import tobyspring.hellospring.payment.service.SimpleExRateProvider;
import tobyspring.hellospring.payment.service.WebApiExRateProvdier;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws IOException {
        ObjectFactory factory = new ObjectFactory();
        PaymentService paymentService = factory.paymentService();
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.valueOf(1304));
        System.out.println("payment = " + payment);
    }
}
