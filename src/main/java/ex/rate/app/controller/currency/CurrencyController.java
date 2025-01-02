package ex.rate.app.controller.currency;

import ex.rate.app.client.DataFetcher;
import ex.rate.app.domain.entity.Currency;
import ex.rate.app.dto.currency.CurrencyDto;
import ex.rate.app.mapper.currency.CurrencyMapper;
import ex.rate.app.repository.CurrencyJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyJpaRepository jpaRepository;

    private final CurrencyMapper mapper;

    @GetMapping(value = "work")
    public String getWelcome(){
        return "server is working . . .";
    }

    @GetMapping("{code}")
    public CurrencyDto gutCurrency(@PathVariable("code") String currencyCode) {
        Currency currency = jpaRepository.findByCurrencyCode(currencyCode);
        return mapper.map(currency);
    }

    @GetMapping("list")
    public List<CurrencyDto> getCurrencies() {
        return jpaRepository.findAll().stream().map(mapper::map).toList();
    }
}
