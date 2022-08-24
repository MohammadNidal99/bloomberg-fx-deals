package com.deals.validator;

import com.deals.dto.DealsDto;
import com.deals.exception.NoDataCustomException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RequestValidatorTest {

    @Autowired
    private Validator validator;

    @Test
    void validate_NullRequest() {

        assertThrows(NoDataCustomException.class, () -> validator.validate(null));
    }

    @Test
    void validate_EmptyFromCurrencyISO() {
        DealsDto dto = new DealsDto();
        dto.setFromCurrencyISO("");
        dto.setToCurrencyISO("JOD");
        dto.setDealAmount(122.3);
        dto.setDealTimeStamp("2022-01-30 00:00:00");
        assertThrows(NoDataCustomException.class, () -> validator.validate(dto));
    }

    @Test
    void validate_EmptyToCurrencyISO() {
        DealsDto dto = new DealsDto();
        dto.setFromCurrencyISO("JOD");
        dto.setToCurrencyISO("");
        dto.setDealAmount(122.3);
        dto.setDealTimeStamp("2022-01-30 00:00:00");
        assertThrows(NoDataCustomException.class, () -> validator.validate(dto));
    }

    @Test
    void validate_NullDealAmount() {
        DealsDto dto = new DealsDto();
        dto.setFromCurrencyISO("JOD");
        dto.setToCurrencyISO("USD");
        dto.setDealAmount(null);
        dto.setDealTimeStamp("2022-01-30 00:00:00");
        assertThrows(NoDataCustomException.class, () -> validator.validate(dto));
    }

    @Test
    void validate_DealAmount_in_Minus() {
        DealsDto dto = new DealsDto();
        dto.setFromCurrencyISO("JOD");
        dto.setToCurrencyISO("USD");
        dto.setDealAmount(-22.3);
        dto.setDealTimeStamp("2022-01-30 00:00:00");
        assertThrows(NoDataCustomException.class, () -> validator.validate(dto));
    }

    @Test
    void validate_DealTimeStamp_InvalidFormat() {
        DealsDto dto = new DealsDto();
        dto.setFromCurrencyISO("JOD");
        dto.setToCurrencyISO("USD");
        dto.setDealAmount(103.3);
        dto.setDealTimeStamp("30-01-2022 00:00:00");
        assertThrows(NoDataCustomException.class, () -> validator.validate(dto));
    }

    @Test
    void validate_DealTimeStamp_Empty() {
        DealsDto dto = new DealsDto();
        dto.setFromCurrencyISO("JOD");
        dto.setToCurrencyISO("USD");
        dto.setDealAmount(103.3);
        dto.setDealTimeStamp("");
        assertThrows(NoDataCustomException.class, () -> validator.validate(dto));
    }


}