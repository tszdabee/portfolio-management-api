package com.example.portfolio.api;

import com.example.portfolio.exception.ResourceNotFoundException;
import com.example.portfolio.model.Stock;
import com.example.portfolio.model.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@CrossOrigin
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockRepository repo;

    private double generateRandomPriceVariation(Stock stock) {
        double variationPercentage = ThreadLocalRandom.current().nextDouble(-0.05, 0.05);
        return variationPercentage;
    }

    @Scheduled(fixedRate = 3000)
    public void updateStockPrices() {
        List<Stock> stocks = repo.findAll();
        for (Stock stock : stocks) {
            double variation = generateRandomPriceVariation(stock);
            double currentPrice = stock.getPrice();
            double newPrice = currentPrice + currentPrice * variation;
            stock.setDailyChange(variation);
            stock.setPrice(newPrice);
            repo.save(stock);
        }
    }

    @GetMapping(value="/", produces="application/json")
    public List<Stock> getAllStock(){
        return repo.findAll();
    }

    @GetMapping( value="/{ticker}", produces = { "application/json" } )
    public Stock getStock( @PathVariable String ticker ) {
        Optional<Stock> result = repo.findById( ticker );
        if ( result.isPresent() ) {
            return result.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    private void updateStockQuantity(String ticker, int qty, boolean isBuy) {
        Optional<Stock> result = repo.findById(ticker);
        if (result.isPresent()) {
            Stock stock = result.get();
            if (isBuy) {
                if (qty <= 0) {
                    throw new IllegalArgumentException("Quantity must be greater than 0 for buying stock.");
                }
                stock.setQuantity(stock.getQuantity() + qty);
            } else {
                if (qty <= 0 || qty > stock.getQuantity()) {
                    throw new IllegalArgumentException("Quantity must be greater than 0 for selling stock.");
                }
                stock.setQuantity(stock.getQuantity() - qty);
            }
            repo.save(stock);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @PutMapping("/{ticker}/buyStock/{qty}")
    public void buyStock(@PathVariable String ticker, @PathVariable int qty) {
        updateStockQuantity(ticker, qty, true);
    }

    @PutMapping("/{ticker}/sellStock/{qty}")
    public void sellStock(@PathVariable String ticker, @PathVariable int qty) {
        updateStockQuantity(ticker, qty, false);
    }
}
