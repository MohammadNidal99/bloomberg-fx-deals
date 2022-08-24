package com.deals.controller;

import com.deals.dto.DealsDto;
import com.deals.service.DealService;
import com.deals.validator.Validator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SubmitDataController.class)
class SubmitDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    DealService dealService;

    @MockBean
    Validator validator;

    @Test
    void persistToDatabase() throws Exception {

        DealsDto dto = new DealsDto();
        dto.setFromCurrencyISO("SAR");
        dto.setToCurrencyISO("JOD");
        dto.setDealAmount(122.3);
        dto.setDealTimeStamp("2022-01-30 00:00:00");

        mockMvc.perform(post("/fx-deals/submit").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().is(200));
    }
}