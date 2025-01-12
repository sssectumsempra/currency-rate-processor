package ex.rate.app.service.port.in;

import ex.rate.app.dto.CurrencyDto;

import java.util.List;

public interface CurrencyService {

    CurrencyDto findByCurrencyCode(String currencyCode);

    List<CurrencyDto> findAll();
}
