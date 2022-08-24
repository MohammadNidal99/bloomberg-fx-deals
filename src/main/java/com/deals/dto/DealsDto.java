package com.deals.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Currency;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
public class DealsDto {

    private Long id;

//    @Currency(message = "", value = {})
    private String fromCurrencyISO;

    private String toCurrencyISO;

    private String dealTimeStamp;

    private Double dealAmount;

}
