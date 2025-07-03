package tobyspring.hellospring.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tobyspring.hellospring.payment.dao.Payment;
import tobyspring.hellospring.payment.service.PaymentService;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PaymentServiceTest {
    Clock clock;

    @BeforeEach
    void beforEach() {
        this.clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
    }

    @Test
<<<<<<< HEAD
    void convertedAmount() throws IOException {
=======
    void convertedAmount() {
>>>>>>> 0802768762e720a70b0378bf4f07e31b590da938

        convertedAmount(BigDecimal.valueOf(100), BigDecimal.valueOf(1_000), this.clock);
        convertedAmount(BigDecimal.valueOf(300), BigDecimal.valueOf(3_000), this.clock);
        convertedAmount(BigDecimal.valueOf(500), BigDecimal.valueOf(5_000), this.clock);
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
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(BigDecimal.valueOf(1_000)), clock);

        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        // validUntil이 prepare() 30분 뒤로 설정됐는가?
        LocalDateTime now = LocalDateTime.now(this.clock);
        LocalDateTime expectedValidUntil = now.plusMinutes(30);

        Assertions.assertThat(payment.getValidUntil()).isEqualTo(expectedValidUntil);
    }

    // 여러 케이스의 입력값을 넣고 하기위해서 테스트케이스를 메서ㅊ드로 분리 시킨다. (우연히 테스트가 성공하는 경우가 있음)
<<<<<<< HEAD
    private static void convertedAmount(BigDecimal exRate, BigDecimal convertedAmount, Clock clock) throws IOException {
=======
    private static void convertedAmount(BigDecimal exRate, BigDecimal convertedAmount, Clock clock) {
>>>>>>> 0802768762e720a70b0378bf4f07e31b590da938
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(exRate), clock);
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);
        // bigdecimal 비교는 isEqualByComparingTo 이걸로 하는게 좋다
        // why? isequalto는 밑 자리수 까지 다 비교

        // 환율정보 가져온다
        assertThat(payment.getExRate()).isEqualByComparingTo(exRate);
        // 원화환산금액 계산
        assertThat(payment.getConvertedAmount()).isEqualByComparingTo(convertedAmount);
    }
}