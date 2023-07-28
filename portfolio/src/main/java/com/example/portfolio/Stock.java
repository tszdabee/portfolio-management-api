package com.example.portfolio;

public class Stock {
    private String id;
    private String companyName;
    private Double price;
    private Double dailyChange;
    private Double quantity;

    public Stock(String id, String companyName, Double price, Double dailyChange, Double quantity){
        System.out.println("hello I am ur constructor!!!");
    }
}
