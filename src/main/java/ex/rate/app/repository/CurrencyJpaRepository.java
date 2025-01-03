package ex.rate.app.repository;

import ex.rate.app.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CurrencyJpaRepository extends JpaRepository<Currency, Long> {

    @Query("select c from Currency c where c.currencyCode = :cc")
    Optional<Currency> findByCurrencyCode(@Param("cc") String currencyCode);
}
