package tobyspring.hellospring.payment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tobyspring.hellospring.payment.dao.ExRateDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

public class WebApiExRateProvdier implements ExRateProvider {
    @Override
    public BigDecimal getExRate(String currency) {
        String url = "https://open.er-api.com/v6/latest/" + currency;
        URI uri;
        String response;
        HttpURLConnection connection;
        ExRateDate data;

        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = (HttpURLConnection) uri.toURL().openConnection();
            // finally 대신 블록안에서 자동으로 리소스를 제거해주는 방법 try(변수 선언부){} -> br.close() 자동 닫힘 (AutoCloseable)
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                response = br.lines().collect(Collectors.joining());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(response, ExRateDate.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return data.rates().get("KRW");
    }
}
