package ex.rate.app.service.port.out;

import ex.rate.app.entity.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyPersistencePort {

    Optional<Currency> findByCurrencyCode(String currencyCode);

    List<Currency> findAll();
}
