package com.example.portfolio;

import com.example.portfolio.model.Stock;
import com.example.portfolio.model.repository.StockRepository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeedDatabase {

    @Autowired
    private StockRepository repository;

    @PostConstruct
    public void init() {

        @Component
        public class SeedDatabase {

            @Autowired
            private StockRepository repository;

            @PostConstruct
            public void init() {
                repository.save(new Stock("AAPL", "Apple Inc.", 150.50, -0.14, 100.0));
                repository.save(new Stock("GOOGL", "Alphabet Inc.", 2800.20, -0.17, 50.0));
                repository.save(new Stock("AMZN", "Amazon.com Inc.", 3250.75, 0.02, 75.0));
                repository.save(new Stock("MSFT", "Microsoft Corporation", 290.40, -0.06, 120.0));
                repository.save(new Stock("TSLA", "Tesla", 700.00, 0.36, 30.0));
                repository.save(new Stock("JPM", "JPMorgan Chase & Co.", 150.80, 0.11, 90.0));
                repository.save(new Stock("NVDA", "NVIDIA Corporation", 220.30, -0.08, 65.0));
                repository.save(new Stock("WMT", "Walmart Inc.", 140.10, -0.15, 110.0));
                repository.save(new Stock("JNJ", "Johnson & Johnson", 170.25, 0.40, 85.0));
                repository.save(new Stock("BAC", "Bank of America Corporation", 40.50, 0.36, 150.0));
                repository.save(new Stock("XOM", "Exxon Mobil Corporation", 60.70, -0.06, 70.0));
                repository.save(new Stock("PFE", "Pfizer Inc.", 45.80, 0.43, 200.0));
                repository.save(new Stock("HD", "The Home Depot", 350.90, 0.33, 40.0));
                repository.save(new Stock("V", "Visa Inc.", 250.60, -0.04, 55.0));
                repository.save(new Stock("PG", "Procter & Gamble Co.", 135.00, -0.06, 100.0));
                repository.save(new Stock("MA", "Mastercard Incorporated", 390.10, -0.11, 25.0));
                repository.save(new Stock("INTC", "Intel Corporation", 55.25, -0.49, 80.0));
                repository.save(new Stock("CRM", "Salesforce", 280.00, -0.45, 45.0));
                repository.save(new Stock("VZ", "Verizon Communications Inc.", 55.50, 0.35, 70.0));
                repository.save(new Stock("KO", "The Coca-Cola Company", 55.75, 0.30, 120.0));
            }

        }

    }

}

