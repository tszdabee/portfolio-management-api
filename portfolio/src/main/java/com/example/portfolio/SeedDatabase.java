package com.example.portfolio;

import com.example.portfolio.model.Stock;
import com.example.portfolio.model.repository.StockRepository;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeedDatabase {

    @Autowired
    private StockRepository repository;

    @PostConstruct
    public void init() {
        repository.save( new Stock("AAPL" ,"Apple Inc.", 150.50, -0.33, 100.0, "Technology") );
        repository.save( new Stock("GOOGL" ,"Alphabet Inc.", 2800.20, 0.18, 50.0, "Technology") );
        repository.save( new Stock("AMZN" ,"Amazon.com Inc.", 3250.75, -0.48, 75.0, "Technology") );
        repository.save( new Stock("MSFT" ,"Microsoft Corporation", 290.40, -0.21, 120.0, "Technology") );
        repository.save( new Stock("TSLA" ,"Tesla", 700.00, 0.38, 30.0, "Automotive") );
        repository.save( new Stock("JPM" ,"JPMorgan Chase & Co.", 150.80, 0.17, 90.0, "Finance") );
        repository.save( new Stock("NVDA" ,"NVIDIA Corporation", 220.30, -0.10, 65.0, "Technology") );
        repository.save( new Stock("WMT" ,"Walmart Inc.", 140.10, 0.32, 110.0, "Retail") );
        repository.save( new Stock("JNJ" ,"Johnson & Johnson", 170.25, 0.43, 85.0, "Healthcare") );
        repository.save( new Stock("BAC" ,"Bank of America Corporation", 40.50, -0.16, 150.0, "Finance") );
        repository.save( new Stock("XOM" ,"Exxon Mobil Corporation", 60.70, 0.07, 70.0, "Energy") );
        repository.save( new Stock("PFE" ,"Pfizer Inc.", 45.80, 0.21, 200.0, "Healthcare") );
        repository.save( new Stock("HD" ,"The Home Depot", 350.90, -0.17, 40.0, "Retail") );
        repository.save( new Stock("V" ,"Visa Inc.", 250.60, -0.02, 55.0, "Finance") );
        repository.save( new Stock("PG" ,"Procter & Gamble Co.", 135.00, -0.13, 100.0, "Consumer Goods") );
        repository.save( new Stock("MA" ,"Mastercard Incorporated", 390.10, 0.12, 25.0, "Finance") );
        repository.save( new Stock("INTC" ,"Intel Corporation", 55.25, -0.32, 80.0, "Technology") );
        repository.save( new Stock("CRM" ,"Salesforce", 280.00, 0.32, 45.0, "Technology") );
        repository.save( new Stock("VZ" ,"Verizon Communications Inc.", 55.50, 0.41, 70.0, "Telecommunications") );
        repository.save( new Stock("KO" ,"The Coca-Cola Company", 55.75, -0.05, 120.0, "Consumer Goods") );
    }

}