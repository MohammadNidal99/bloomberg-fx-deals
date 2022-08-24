package com.deals.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "deals")
public class Deals {

    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDateTime dateTime;

    @Column(name = "from_currency_ISO")
    private String fromCurrencyISO;

    @Column(name = "to_currency_ISO")
    private String toCurrencyISO;

    @Column(name = "deal_time_stamp")
    private String dealTimeStamp;

    @Column(name = "deal_amount")
    private Double dealAmount;


    public String getFromCurrencyISO() {
        return fromCurrencyISO;
    }

    public void setFromCurrencyISO(String fromCurrencyISO) {
        this.fromCurrencyISO = fromCurrencyISO;
    }

    public String getToCurrencyISO() {
        return toCurrencyISO;
    }

    public void setToCurrencyISO(String toCurrencyISO) {
        this.toCurrencyISO = toCurrencyISO;
    }

    public String getDealTimeStamp() {
        return dealTimeStamp;
    }

    public void setDealTimeStamp(String dealTimeStamp) {
        this.dealTimeStamp = dealTimeStamp;
    }

    public Double getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(Double dealAmount) {
        this.dealAmount = dealAmount;
    }
}
