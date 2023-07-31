package com.example.portfolio.model;

import org.springframework.data.annotation.Id;

public class Stock {

    @Id
    private String ticker;
    private String companyName;
    private Double price;
    private Double dailyChange;
    private Double quantity;

    public Stock(String ticker, String companyName, Double price, Double dailyChange, Double quantity){
        this.ticker = ticker;
        this.companyName = companyName;
        this.price = price;
        this.dailyChange = dailyChange;
        this.quantity = quantity;
    }

    public String getTicker(){
        return ticker;
    }

    public String getCompanyName(){
        return companyName;
    }

    public Double getPrice(){
        return price;
    }

    public Double getDailyChange(){
        return dailyChange;
    }

    public Double getQuantity(){
        return quantity;
    }


}
