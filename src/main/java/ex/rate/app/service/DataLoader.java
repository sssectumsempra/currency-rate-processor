package ex.rate.app.service;

import ex.rate.app.client.DataFetcher;
import ex.rate.app.domain.entity.Currency;
import ex.rate.app.repository.CurrencyJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final DataFetcher dataFetcher;

    private final CurrencyJpaRepository currencyJpaRepository;

    @Scheduled(initialDelay = 1000, fixedDelay = 3600000) // fixed delay every 60 minutes
    public void loadData() {
        List<Currency> currencies = dataFetcher.fetchDataFromJson();
        currencyJpaRepository.saveAll(currencies);
    }
}
