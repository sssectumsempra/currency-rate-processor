package ex.rate.app.service;

import ex.rate.app.dto.CurrencyDto;
import ex.rate.app.entity.Currency;
import ex.rate.app.exception.CurrencyNotFoundException;
import ex.rate.app.mapper.currency.CurrencyMapper;
import ex.rate.app.repository.CurrencyJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyJpaRepository repository;

    private final CurrencyMapper mapper;

    @Override
    public CurrencyDto findByCurrencyCode(String currencyCode) {
        Currency currency = repository.findByCurrencyCode(currencyCode)
                .orElseThrow(() -> new CurrencyNotFoundException("Currency not found"));
        return mapper.map(currency);
    }

    @Override
    public List<CurrencyDto> findAll() {
        List<CurrencyDto> currencyDtoList = repository.findAll().stream().map(mapper::map).toList();
        if (currencyDtoList.isEmpty()) {
            throw new CurrencyNotFoundException("No currencies found");
        }
        return currencyDtoList;
    }
}
