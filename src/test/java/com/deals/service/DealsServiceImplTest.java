package com.deals.service;

import com.deals.dto.DealsDto;
import com.deals.repository.DealsRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DealsServiceImplTest {

    @InjectMocks
    private DealService dealService = new DealsServiceImpl();

    @Mock
    DealsRepo dealsRepo = Mockito.mock(DealsRepo.class);

    @Test
    void saveDeals_Throw_Exception() throws Exception {

        DealsDto dto = new DealsDto();
        dto.setFromCurrencyISO("SAR");
        dto.setToCurrencyISO("JOD");
        dto.setDealAmount(122.3);
        dto.setDealTimeStamp("2022-01-30 00:00:00");

        when(dealsRepo.save(any())).thenThrow(RuntimeException.class);
        assertThrows(Exception.class, () -> dealService.saveDeals(dto));
    }

    @Test
    void isFound() {
    }
}