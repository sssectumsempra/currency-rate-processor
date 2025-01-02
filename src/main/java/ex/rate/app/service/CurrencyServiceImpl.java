package ex.rate.app.service;

import ex.rate.app.dto.CurrencyDto;
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
        return mapper.map(repository.findByCurrencyCode(currencyCode));
    }

    @Override
    public List<CurrencyDto> findAll() {
        return repository.findAll().stream().map(mapper::map).toList();
    }
}
