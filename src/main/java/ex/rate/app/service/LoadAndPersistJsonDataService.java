package ex.rate.app.service;

import ex.rate.app.client.DataFetcher;
import ex.rate.app.entity.Currency;
import ex.rate.app.repository.CurrencyJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoadAndPersistJsonDataService {

    private final DataFetcher dataFetcher;

    private final CurrencyJpaRepository currencyJpaRepository;

    @Scheduled(initialDelay = 1000, fixedDelay = 3600000)
    public void loadData() {
        List<Currency> currencies = dataFetcher.fetchDataFromJson();

        log.info("Saving currencies to DB.");
        currencyJpaRepository.saveAll(currencies);
    }
}
