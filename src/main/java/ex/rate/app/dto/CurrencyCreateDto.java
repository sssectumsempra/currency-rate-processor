package ex.rate.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CurrencyCreateDto {

    @JsonProperty("r030")
    private Integer reference;

    @JsonProperty("txt")
    private String name;

    @JsonProperty("rate")
    private Double rate;

    @JsonProperty("cc")
    private String currencyCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @JsonProperty("exchangedate")
    private LocalDate exchangeDate;
}
