package ex.rate.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

import java.time.LocalDate;

@Setter
@Getter
public class CurrencyUpdateDto {

    @JsonProperty("r030")
    private JsonNullable<Integer> reference;

    @JsonProperty("txt")
    private JsonNullable<String> name;

    @JsonProperty("rate")
    private JsonNullable<Double> rate;

    @JsonProperty("cc")
    private JsonNullable<String> currencyCode;

    @JsonProperty("exchangedate")
    private JsonNullable<LocalDate> exchangeDate;
}
