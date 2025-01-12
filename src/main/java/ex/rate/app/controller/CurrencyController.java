package ex.rate.app.controller;

import ex.rate.app.dto.CurrencyDto;
import ex.rate.app.service.port.in.CurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "${application.endpoint.controller.root}")
@RequiredArgsConstructor
@Slf4j
public class CurrencyController {

    private final CurrencyService service;

    @GetMapping("{code}")
    public ResponseEntity<CurrencyDto> gutCurrency(@PathVariable("code") String currencyCode) {
        log.info("Received request to get currency by currency code: {}", currencyCode);
        return ResponseEntity.ok(service.findByCurrencyCode(currencyCode));
    }

    @GetMapping(value = "currencies", produces = "application/json")
    public ResponseEntity<List<CurrencyDto>> getCurrencies() {
        log.info("Received request to get currencies list");
        return ResponseEntity.ok(service.findAll());
    }
}
