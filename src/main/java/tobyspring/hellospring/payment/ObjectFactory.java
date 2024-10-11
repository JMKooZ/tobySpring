package tobyspring.hellospring.payment;

import tobyspring.hellospring.payment.service.ExRateProvider;
import tobyspring.hellospring.payment.service.PaymentService;
import tobyspring.hellospring.payment.service.WebApiExRateProvdier;

public class ObjectFactory {
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    public ExRateProvider exRateProvider(){
        return new WebApiExRateProvdier();
    }
}
