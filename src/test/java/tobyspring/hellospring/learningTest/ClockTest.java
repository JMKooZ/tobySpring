package tobyspring.hellospring.learningTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ClockTest {
    // Clock 을 통해 LocalDateTime.now 를 사용한다면 호출할때마다 잘 동작하는지
    // mac 과 windows os간의 clock(now) 가 다르게 동작 그래서 Thread.sleep 사용

    @Test
    void Clock() throws InterruptedException {
        Clock clock = Clock.systemDefaultZone();

        LocalDateTime dt1 = LocalDateTime.now(clock);
        Thread.sleep(1);
        LocalDateTime dt2 = LocalDateTime.now(clock);

        Assertions.assertThat(dt2).isAfter(dt1);
    }
    // Clock 을 테스트에서 사용할 때 원하는 시간을 지정해 현재시간을 가져오게 할 수 있는가?

    @Test
    void fixedClock() {
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

        LocalDateTime dt1 = LocalDateTime.now(clock);
        LocalDateTime dt2 = LocalDateTime.now(clock);
        LocalDateTime dt3 = LocalDateTime.now(clock).plusMinutes(30);

        Assertions.assertThat(dt1).isEqualTo(dt2);
        Assertions.assertThat(dt3).isEqualTo(dt1.plusMinutes(30));

    }
}
