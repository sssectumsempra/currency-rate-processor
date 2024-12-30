package ex.rate.app.client;
import com.fasterxml.jackson.databind.ObjectMapper;
import ex.rate.app.domain.entity.Currency;
import lombok.RequiredArgsConstructor;
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
public class DataFetcher {

    private final ObjectMapper objectMapper;

    public List<Currency> fetchDataFromJson() {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(JSON_URL))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            String jsonResponse = response.body();

            List<Currency> list = Arrays.stream(objectMapper.readValue(jsonResponse.getBytes(), Currency[].class)).toList();

            return list;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch or parse JSON", e);
        }
    }
}
