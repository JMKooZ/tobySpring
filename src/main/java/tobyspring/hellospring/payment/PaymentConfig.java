package tobyspring.hellospring.payment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobyspring.hellospring.payment.service.ExRateProvider;
import tobyspring.hellospring.payment.service.PaymentService;
import tobyspring.hellospring.payment.service.WebApiExRateProvdier;

import java.time.Clock;

@Configuration
public class PaymentConfig {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvdier();
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
