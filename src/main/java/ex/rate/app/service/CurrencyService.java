package ex.rate.app.service;

import ex.rate.app.dto.CurrencyDto;

import java.util.List;
import java.util.Optional;

public interface CurrencyService {

    CurrencyDto findByCurrencyCode(String currencyCode);

    List<CurrencyDto> findAll();


}
