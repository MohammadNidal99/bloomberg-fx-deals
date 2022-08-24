package com.deals.repository;

import com.deals.entity.Deals;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealsRepo extends CrudRepository<Deals, Long> {

    @Query("SELECT COUNT(*) FROM Deals d WHERE d.fromCurrencyISO= ?1 and d.toCurrencyISO= ?2 and d.dealTimeStamp= ?3 and d.dealAmount= ?4")
    Long countDeals(String fromCurrencyISO, String toCurrencyISO, String dealTimeStamp, Double dealAmount);
}
