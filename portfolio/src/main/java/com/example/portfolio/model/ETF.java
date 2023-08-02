package com.example.portfolio.model;

import org.springframework.data.annotation.Id;

public class ETF {

    @Id
    private String ticker;
    private String ETFName;
    private Double shares;
    private Double averagePrice;
    private Double cost;
    private Double currentPrice;
    private Double value;
    private Double percentReturn;
    private Double dollarReturn;
    private Double dividendYield;
    private Double peRatio;
    private Double oneYearReturn;
    private Double volatility;
    private String sector;

    public ETF(String ticker, String ETFName, Double shares, Double averagePrice, Double cost, Double currentPrice,
               Double value, Double percentReturn, Double dollarReturn, Double dividendYield, Double peRatio,
               Double oneYearReturn, Double volatility, String sector) {
        this.ticker = ticker;
        this.ETFName = ETFName;
        this.shares = shares;
        this.averagePrice = averagePrice;
        this.cost = cost;
        this.currentPrice = currentPrice;
        this.value = value;
        this.percentReturn = percentReturn;
        this.dollarReturn = dollarReturn;
        this.dividendYield = dividendYield;
        this.peRatio = peRatio;
        this.oneYearReturn = oneYearReturn;
        this.volatility = volatility;
        this.sector = sector;
    }

    public String getTicker() {
        return ticker;
    }

    public String getETFName() {
        return ETFName;
    }

    public Double getShares() {
        return shares;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public Double getCost() {
        return cost;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public Double getValue() {
        return value;
    }

    public Double getPercentReturn() {
        return percentReturn;
    }

    public Double getDollarReturn() {
        return dollarReturn;
    }

    public Double getDividendYield() {
        return dividendYield;
    }

    public Double getPeRatio() {
        return peRatio;
    }

    public Double getOneYearReturn() {
        return oneYearReturn;
    }

    public Double getVolatility() {
        return volatility;
    }

    public String getSector() {
        return sector;
    }

    public void setShares(Double shares) {
        this.shares = shares;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setPercentReturn(Double percentReturn) {
        this.percentReturn = percentReturn;
    }
}
