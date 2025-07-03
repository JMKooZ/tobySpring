package tobyspring.hellospring.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tobyspring.hellospring.TestPaymentConfig;
import tobyspring.hellospring.payment.dao.Payment;
import tobyspring.hellospring.payment.service.PaymentService;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// 구성정보를 읽고 스프링 컨테이너를 만든다
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestPaymentConfig.class)
class PaymentServiceSpringTest {

    @Autowired
    PaymentService paymentService;

    @Autowired
    ExRateProviderStub exRateProviderStub;

    @Autowired
    Clock clock;

    @Test
<<<<<<< HEAD
    void convertedAmount() throws IOException {
=======
    void convertedAmount() {
>>>>>>> 0802768762e720a70b0378bf4f07e31b590da938
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        // exRate = 1000
        assertThat(payment.getExRate()).isEqualByComparingTo(BigDecimal.valueOf(1_000));
        assertThat(payment.getConvertedAmount()).isEqualByComparingTo(BigDecimal.valueOf(10_000));

        // exRate = 500
        exRateProviderStub.setExRate(BigDecimal.valueOf(500));
        Payment payment2 = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        assertThat(payment2.getExRate()).isEqualByComparingTo(BigDecimal.valueOf(500));
        assertThat(payment2.getConvertedAmount()).isEqualByComparingTo(BigDecimal.valueOf(5_000));

//        Payment payment = new Payment();

        // 원화환산금액의 유효시간 계산
//        assertThat(payment.getValidUntil()).isBefore(LocalDateTime.now().plusMinutes(30));
//        assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
    }

    @Test
<<<<<<< HEAD
    void validUntil() throws IOException {
=======
    void validUntil() {
>>>>>>> 0802768762e720a70b0378bf4f07e31b590da938
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        // validUntil이 prepare() 30분 뒤로 설정됐는가?
        LocalDateTime now = LocalDateTime.now(this.clock);
        LocalDateTime expectedValidUntil = now.plusMinutes(30);

        Assertions.assertThat(payment.getValidUntil()).isEqualTo(expectedValidUntil);
    }
}