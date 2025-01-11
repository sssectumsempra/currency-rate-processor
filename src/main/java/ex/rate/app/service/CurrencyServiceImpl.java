package ex.rate.app.service;

import ex.rate.app.dto.CurrencyDto;
import ex.rate.app.entity.Currency;
import ex.rate.app.exception.CurrencyNotFoundException;
import ex.rate.app.mapper.currency.CurrencyMapper;
import ex.rate.app.repository.CurrencyJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyJpaRepository repository;

    private final CurrencyMapper mapper;

    @Override
    public CurrencyDto findByCurrencyCode(String currencyCode) {
        Optional<Currency> currency = repository.findByCurrencyCode(currencyCode);
        if (currency.isEmpty()) {
            log.warn("No currency found for code: {}", currencyCode);
            throw new CurrencyNotFoundException("Currency not found for code: " + currencyCode);
        }
        return mapper.map(currency.get());
    }

    @Override
    public List<CurrencyDto> findAll() {
        List<CurrencyDto> currencyDtoList = repository.findAll().stream()
                .map(mapper::map)
                .toList();
        if (currencyDtoList.isEmpty()) {
            log.warn("No currencies found.");
        }
        return currencyDtoList;
    }
}
