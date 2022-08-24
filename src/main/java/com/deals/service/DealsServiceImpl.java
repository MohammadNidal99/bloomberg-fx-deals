package com.deals.service;

import com.deals.controller.SubmitDataController;
import com.deals.dto.DealsDto;
import com.deals.entity.Deals;
import com.deals.repository.DealsRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class DealsServiceImpl implements DealService {

    @Autowired
    private DealsRepo dealsRepo;

    private static final Logger LOGGER = LogManager.getLogger(DealsServiceImpl.class);

    public void saveDeals(DealsDto request) throws Exception {

        LOGGER.info("Preparing entity before saving to Database");

        Deals deals = new Deals();
        deals.setDealAmount(request.getDealAmount());
        deals.setDealTimeStamp(request.getDealTimeStamp());
        deals.setFromCurrencyISO(request.getFromCurrencyISO());
        deals.setToCurrencyISO(request.getToCurrencyISO());
        try {
            LOGGER.info("Saving to Database");
            dealsRepo.save(deals);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new Exception("System Error: Cannot Save Data in Database: \n  Error Info: {}" +  e.getMessage());
        }

    }

    public boolean isFound(DealsDto request) {
        LOGGER.info("Check if there is similar request in Database");
        Long numOfDeals = dealsRepo.countDeals(request.getFromCurrencyISO(), request.getToCurrencyISO(), request.getDealTimeStamp(), request.getDealAmount());

        return numOfDeals >= 1;
    }
}
