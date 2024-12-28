package ex.rate.app.controller.currency;

import ex.rate.app.client.ExchangeRateClient;
import ex.rate.app.dto.currency.CurrencyDto;
import ex.rate.app.mapper.currency.CurrencyMapper;
import ex.rate.app.repository.CurrencyJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "api/")
@RequiredArgsConstructor
public class CurrencyController {


    private final ExchangeRateClient client;

    private final CurrencyJpaRepository jpaRepository;

    private final CurrencyMapper mapper;



    @GetMapping(value = "welcome")
    public String getWelcome(){
        return "server is working . . .";
    }

    @GetMapping("list")
    public List<CurrencyDto> getCurrencies() throws IOException {
        client.test();
        return jpaRepository.findAll().stream().map(mapper::map).toList();
    }
}
