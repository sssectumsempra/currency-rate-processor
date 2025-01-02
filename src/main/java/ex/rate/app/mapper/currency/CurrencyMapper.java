package ex.rate.app.mapper.currency;

import ex.rate.app.domain.entity.Currency;
import ex.rate.app.dto.currency.CurrencyCreateDto;
import ex.rate.app.dto.currency.CurrencyDto;
import ex.rate.app.dto.currency.CurrencyUpdateDto;
import ex.rate.app.mapper.jsonnullable.JsonNullableMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Consumer;

@Mapper(
        uses = JsonNullableMapper.class,
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class CurrencyMapper {

    @Autowired
    private JsonNullableMapper jsonNullableMapper;

    public abstract Currency map(CurrencyCreateDto dto);

    @Mapping(target = "reference", source = "reference")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "rate", source = "rate")
    @Mapping(target = "currencyCode", source = "currencyCode")
    @Mapping(target = "exchangeDate", source = "exchangeDate")
    public abstract CurrencyDto map(Currency currency);

    public void update(CurrencyUpdateDto dto, @MappingTarget Currency currency) {
        updateFields(dto.getReference(), currency::setReference);
        updateFields(dto.getName(), currency::setName);
        updateFields(dto.getRate(), currency::setRate);
        updateFields(dto.getCurrencyCode(), currency::setCurrencyCode);
        updateFields(dto.getExchangeDate(), currency::setExchangeDate);
    }

    private <T> void updateFields(JsonNullable<T> dto, Consumer<T> currency){
        if (jsonNullableMapper.isPresent(dto)) {
            currency.accept(jsonNullableMapper.unwrap(dto));
        }
    }
}
