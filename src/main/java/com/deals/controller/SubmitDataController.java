package com.deals.controller;

import com.deals.dto.DealsDto;
import com.deals.service.DealService;
import com.deals.validator.RequestValidator;
import com.deals.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/fx-deals")
@RestController
public class SubmitDataController {

    private static final Logger LOGGER = LogManager.getLogger(SubmitDataController.class);

    @Autowired
    private DealService dealsService;

    @Autowired
    private Validator requestValidator;

    @PostMapping("/submit")
    public ResponseEntity<String> persistToDatabase(@RequestBody DealsDto request) throws Exception {

        LOGGER.info("Request: " + request);

        requestValidator.validate(request);

        LOGGER.info("Request Validated ");
        if (dealsService.isFound(request)) {
            LOGGER.info("Request is Duplicated");
            return ResponseEntity.badRequest().body("Can't Submit the same request two times");
        }
        dealsService.saveDeals(request);

        LOGGER.info("Request Saved Successfully to Database");
        return ResponseEntity.ok("Submitted");
    }


}
