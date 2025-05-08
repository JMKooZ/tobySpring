package tobyspring.hellospring.payment;

import org.junit.jupiter.api.Test;
import tobyspring.hellospring.payment.dao.Payment;
import tobyspring.hellospring.payment.service.PaymentService;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PaymentServiceTest {

    @Test
    void prepare() throws IOException {
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(BigDecimal.valueOf(500)));
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        // 환율정보 가져온다
        assertThat(payment.getExRate()).isEqualTo(BigDecimal.valueOf(500));

        // 원화환산금액 계산
        assertThat(payment.getConvertedAmount())
                .isEqualTo(BigDecimal.valueOf(5_000));

        // 원화환산금액의 유효시간 계산
        assertThat(payment.getValidUntil()).isBefore(LocalDateTime.now().plusMinutes(30));
        assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
    }
}