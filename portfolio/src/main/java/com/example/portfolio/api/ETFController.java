package com.example.portfolio.api;

import com.example.portfolio.exception.ResourceNotFoundException;
import com.example.portfolio.model.ETF;
import com.example.portfolio.model.repository.ETFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@CrossOrigin
@RequestMapping("/etf")
public class ETFController {
    @Autowired
    private ETFRepository repo;

    private double generateRandomPriceVariation(ETF etf) {
        double variationPercentage = ThreadLocalRandom.current().nextDouble(-0.025, 0.025);
        return variationPercentage;
    }

    @Scheduled(fixedRate = 3000)
    public void updateETFPrices() {
        List<ETF> etfs = repo.findAll();
        for (ETF etf : etfs) {
            double variation = generateRandomPriceVariation(etf);
            double currentPrice = etf.getCurrentPrice();
            double newPrice = currentPrice + currentPrice * variation;
            //etf.setDailyChange(variation);
            etf.setCurrentPrice(newPrice);
            repo.save(etf);
        }
    }

    @GetMapping(value = "/", produces = "application/json")
    public List<ETF> getAllETFs() {
        return repo.findAll();
    }

    @GetMapping(value = "/{ticker}", produces = {"application/json"})
    public ETF getETF(@PathVariable String ticker) {
        Optional<ETF> result = repo.findById(ticker);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    private void updateETFQuantity(String ticker, double quantity, boolean isBuy) {
        Optional<ETF> result = repo.findById(ticker);
        if (result.isPresent()) {
            ETF etf = result.get();
            if (isBuy) {
                if (quantity <= 0) {
                    throw new IllegalArgumentException("Quantity must be greater than 0 for buying ETF.");
                }
                etf.setShares(etf.getShares() + quantity);
            } else {
                if (quantity <= 0 || quantity > etf.getShares()) {
                    throw new IllegalArgumentException("Quantity must be greater than 0 and less than available shares for selling ETF.");
                }
                etf.setShares(etf.getShares() - quantity);
            }
            repo.save(etf);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @PutMapping("/{ticker}/buyETF/{quantity}")
    public void buyETF(@PathVariable String ticker, @PathVariable double quantity) {
        updateETFQuantity(ticker, quantity, true);
    }

    @PutMapping("/{ticker}/sellETF/{quantity}")
    public void sellETF(@PathVariable String ticker, @PathVariable double quantity) {
        updateETFQuantity(ticker, quantity, false);
    }
}
