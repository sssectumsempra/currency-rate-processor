package ex.rate.app.controller;

import ex.rate.app.dto.CurrencyDto;
import ex.rate.app.entity.Currency;
import ex.rate.app.mapper.currency.CurrencyMapper;
import ex.rate.app.repository.CurrencyJpaRepository;
import ex.rate.app.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "${application.endpoint.controller.root}")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService service;

    @GetMapping("{code}")
    public ResponseEntity<CurrencyDto> gutCurrency(@PathVariable("code") String currencyCode) {
        return ResponseEntity.ok(service.findByCurrencyCode(currencyCode));
    }

    @GetMapping(value = "currencies", produces = "application/json")
    public ResponseEntity<List<CurrencyDto>> getCurrencies() {
        return ResponseEntity.ok(service.findAll());
    }
}
