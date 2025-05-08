package tobyspring.hellospring.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import tobyspring.hellospring.payment.Sort;

import java.util.Arrays;
import java.util.List;

public class SortTest {
    Sort sort;

    @BeforeEach
    @Order(2)
    void beforeEach(){
        sort = new Sort();
    }

    @AfterAll
    static void afterAll(){
        System.out.println("AfterAll = 실행완료됐다");
    }

    @Test
    void sort() {
        // 준비
        // 구현(실행)
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));
        // 검증
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa"));
        System.out.println(list);
    }

    @Test
    void sort3Items() {
        // 준비
        // 구현(실행)
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b", "ccc"));
        // 검증
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa", "ccc"));
        System.out.println(list);
    }
}
