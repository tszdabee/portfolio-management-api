package com.example.portfolio.model;

import org.springframework.data.annotation.Id;

public class Index {
    @Id
    private String symbol;
    private String indexName;
    private Double price;
    private Double dailyChange;
    private Double quantity;
    private String dailyTechnical;

    public Index(String symbol, String indexName, Double price, Double dailyChange, Double quantity, String dailyTechnical){
        this.symbol=symbol;
        this.indexName=indexName;
        this.price=price;
        this.dailyChange=dailyChange;
        this.quantity=quantity;
        this.dailyTechnical=dailyTechnical;
    }

    public String getSymbol(){
        return symbol;
    }

    public String getIndexName(){
        return indexName;
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

    public String getDailyTechnical(){
        return dailyTechnical;
    }

    public void setQuantity(Double qty){
        this.quantity=qty;
    }
}
