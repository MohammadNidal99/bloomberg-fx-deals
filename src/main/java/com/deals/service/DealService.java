package com.deals.service;

import com.deals.dto.DealsDto;
import org.springframework.stereotype.Service;

@Service
public interface DealService {

    void saveDeals(DealsDto request) throws Exception;

    boolean isFound(DealsDto request);

}
