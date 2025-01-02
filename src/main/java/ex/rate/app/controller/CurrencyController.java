package ex.rate.app.controller;

import ex.rate.app.dto.CurrencyDto;
import ex.rate.app.entity.Currency;
import ex.rate.app.mapper.currency.CurrencyMapper;
import ex.rate.app.repository.CurrencyJpaRepository;
import ex.rate.app.service.CurrencyService;
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

    private final CurrencyService service;

    @GetMapping(value = "work")
    public String getWelcome(){
        return "server is working . . .";
    }

    @GetMapping("{code}")
    public CurrencyDto gutCurrency(@PathVariable("code") String currencyCode) {
        return service.findByCurrencyCode(currencyCode);
    }

    @GetMapping("list")
    public List<CurrencyDto> getCurrencies() {
        return service.findAll();
    }
}
