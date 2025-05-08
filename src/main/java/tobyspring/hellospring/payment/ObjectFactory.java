package tobyspring.hellospring.payment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobyspring.hellospring.payment.service.ExRateProvider;
import tobyspring.hellospring.payment.service.PaymentService;
import tobyspring.hellospring.payment.service.SimpleExRateProvider;
import tobyspring.hellospring.payment.service.WebApiExRateProvdier;
@Configuration
public class ObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }
    @Bean
    public ExRateProvider exRateProvider(){
        return new SimpleExRateProvider();
    }
}
