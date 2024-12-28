package ex.rate.app.repository;

import ex.rate.app.domain.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyJpaRepository extends JpaRepository<Currency, Long> {
}
