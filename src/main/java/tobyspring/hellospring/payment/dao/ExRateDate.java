package tobyspring.hellospring.payment.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExRateDate(String result, Map<String, BigDecimal> rates) {

}
