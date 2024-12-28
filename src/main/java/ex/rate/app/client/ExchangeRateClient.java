package ex.rate.app.client;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ex.rate.app.domain.entity.Currency;
import ex.rate.app.dto.currency.CurrencyCreateDto;
import ex.rate.app.mapper.currency.CurrencyMapper;
import ex.rate.app.repository.CurrencyJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static ex.rate.app.client.constant.ClientConstant.JSON_URL;

@Component
@RequiredArgsConstructor
public class ExchangeRateClient {

    private final ObjectMapper objectMapper;

    private final CurrencyMapper currencyMapper;

    private final CurrencyJpaRepository jpaRepository;

    public void test() throws IOException {
        URL url = new URL(JSON_URL);
        List<CurrencyCreateDto> currencyCreateDto = objectMapper.readValue(url, new TypeReference<>(){});

        List<Currency> currency = currencyCreateDto.stream().map(currencyMapper::map).toList();

        jpaRepository.saveAll(currency);
    }
}
