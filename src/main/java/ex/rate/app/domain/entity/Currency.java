package ex.rate.app.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "r030")
    private String uniqueReferenceNumber;

    @Column(name = "txt")
    private String title;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "cc")
    private String currencyCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @Column(name = "exchangedate")
    private LocalDate exchangeDate;
}
