package tobyspring.hellospring.payment;

import tobyspring.hellospring.payment.service.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class ExRateProviderStub implements ExRateProvider {
    private BigDecimal exRate;


    public ExRateProviderStub(BigDecimal exRate) {
        this.exRate = exRate;
    }

    public BigDecimal getExRate() {
        return exRate;
    }

    public void setExRate(BigDecimal exRate) {
        this.exRate = exRate;
    }

    @Override
<<<<<<< HEAD
    public BigDecimal getExRate(String currency) throws IOException {
=======
    public BigDecimal getExRate(String currency) {
>>>>>>> 0802768762e720a70b0378bf4f07e31b590da938

        return exRate;
    }
}
