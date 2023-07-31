package com.example.portfolio.api;

import com.example.portfolio.exception.ResourceNotFoundException;
import com.example.portfolio.model.Stock;
import com.example.portfolio.model.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockRepository repo;

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
}
