package tobyspring.hellospring.payment.service;

import java.io.IOException;
import java.math.BigDecimal;

public interface ExRateProvider {
    BigDecimal getExRate(String currency) throws IOException;
}
