package com.deals.validator;

import com.deals.dto.DealsDto;
import com.deals.exception.NoDataCustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;


@Component
public class RequestValidator implements Validator {

    private static final Logger LOGGER = LogManager.getLogger(RequestValidator.class);
    public void validate(DealsDto request) {

        LOGGER.info("Start Validating Request");

        LOGGER.info("Check if Request is Equals to Null");
        if (request == null) {
            LOGGER.error("Request is Equals to Null");
            throw new NoDataCustomException("Request Is Null");
        }

        LOGGER.info("Check if From_Currency_ISO Equals to Null or Empty");
        if (request.getFromCurrencyISO() == null || request.getFromCurrencyISO().isEmpty()) {
            LOGGER.error("From_Currency_ISO Equals to Null or Empty");
            throw new NoDataCustomException("From Currency ISO Is Null or Empty");
        }

        LOGGER.info("Check if TO_Currency_ISO Equals to Null or Empty");
        if (request.getToCurrencyISO() == null || request.getToCurrencyISO().isEmpty()) {
            LOGGER.error("TO_Currency_ISO Equals to Null or Empty");
            throw new NoDataCustomException("To Currency ISO Is Null or Empty");
        }
        LOGGER.info("Check if Currency Code is Valid");
        validateIsoCode(request.getFromCurrencyISO());
        validateIsoCode(request.getToCurrencyISO());

        LOGGER.info("Check if Deal_Amount Equals to Null or Less than Zero");
        if (request.getDealAmount() == null || request.getDealAmount() < 0) {
            LOGGER.error("Deal_Amount Equals to Null or Less than Zero");
            throw new NoDataCustomException("Deal Amount Is Null or Less than Zero");
        }

        LOGGER.info("Check if Deal_Time_Stamp Equals to Null or Empty");
        if (request.getDealTimeStamp() == null || request.getDealTimeStamp().isEmpty() || !validateDate(request.getDealTimeStamp())) {
            LOGGER.error("Deal_Time_Stamp Equals to Null or Empty");
            throw new NoDataCustomException("Deal Time Shouldn't be null or empty, and the format should be yyyy-MM-dd HH:mm:ss");
        }

    }

    private boolean validateDate(String timestamp) {

        LOGGER.info("Validating Timestamp");
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(timestamp, formatter);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            LOGGER.error("Timestamp is not valid");
            return false;
        }
        LOGGER.info("Timestamp is Valid");
        return true;
    }

    private void validateIsoCode(String code) {

        LOGGER.info("Validating Currency code");
        try {
            Currency currency = Currency.getInstance(code);
        } catch (NullPointerException e) {
            LOGGER.warn("Currency Code Not Found");
            throw new NoDataCustomException(code + " Not Found");
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Currency Code Not Valid");
            throw new NoDataCustomException(code + " Not Supported as ISO Code");
        }
    }

}
