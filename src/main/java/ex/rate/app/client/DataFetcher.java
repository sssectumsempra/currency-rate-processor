package ex.rate.app.client;
import com.fasterxml.jackson.databind.ObjectMapper;
import ex.rate.app.entity.Currency;
import ex.rate.app.dto.CurrencyCreateDto;
import ex.rate.app.mapper.currency.CurrencyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

import static ex.rate.app.client.constant.ClientConstant.JSON_URL;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataFetcher {
    private final HttpClient httpClient;

    private final ObjectMapper objectMapper;

    private final CurrencyMapper mapper;

    public List<Currency> fetchDataFromJson() {
        log.info("Getting http request by URL...");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(JSON_URL))
                .GET()
                .build();
        HttpResponse<String> httpResponse;
        try {
            log.info("Sending http request by URL...");
            httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            String jsonResponse = httpResponse.body();

            List<CurrencyCreateDto> list = Arrays.stream(objectMapper.readValue(jsonResponse.getBytes(), CurrencyCreateDto[].class)).toList();

            return list.stream().map(mapper::map).toList();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Failed to fetch or parse JSON", e);
        }
    }
}
