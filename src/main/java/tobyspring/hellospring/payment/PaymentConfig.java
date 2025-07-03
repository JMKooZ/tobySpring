package tobyspring.hellospring.payment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobyspring.hellospring.payment.service.ExRateProvider;
import tobyspring.hellospring.payment.service.PaymentService;
<<<<<<< HEAD
import tobyspring.hellospring.payment.service.SimpleExRateProvider;
=======
import tobyspring.hellospring.payment.service.WebApiExRateProvdier;
>>>>>>> 0802768762e720a70b0378bf4f07e31b590da938

import java.time.Clock;

@Configuration
public class PaymentConfig {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    public ExRateProvider exRateProvider() {
<<<<<<< HEAD
        return new SimpleExRateProvider();
=======
        return new WebApiExRateProvdier();
>>>>>>> 0802768762e720a70b0378bf4f07e31b590da938
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
