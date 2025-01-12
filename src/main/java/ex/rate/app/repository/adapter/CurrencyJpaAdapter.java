package ex.rate.app.repository.adapter;

import ex.rate.app.entity.Currency;
import ex.rate.app.repository.CurrencyJpaRepository;
import ex.rate.app.service.port.out.CurrencyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CurrencyJpaAdapter implements CurrencyPersistencePort {

    private final CurrencyJpaRepository repository;

    @Override
    public Optional<Currency> findByCurrencyCode(String currencyCode) {
        return repository.findByCurrencyCode(currencyCode);
    }

    @Override
    public List<Currency> findAll() {
        return repository.findAll();
    }
}
