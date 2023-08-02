package com.example.portfolio.api;

import com.example.portfolio.exception.ResourceNotFoundException;
import com.example.portfolio.model.Index;
import com.example.portfolio.model.repository.IndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private IndexRepository indexRepo;

    @GetMapping(value="/", produces = "application/json")
    public List<Index> getAllIndex(){
        return indexRepo.findAll();
    }

    @GetMapping( value="/{symbol}", produces = { "application/json" } )
    public Index getIndex(@PathVariable String symbol ) {
        Optional<Index> result = indexRepo.findById( symbol );
        if ( result.isPresent() ) {
            return result.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    private void updateIndexQuantity(String symbol, int qty, boolean isBuy) {
        Optional<Index> result = indexRepo.findById(symbol);
        if (result.isPresent()) {
            Index index = result.get();
            if (isBuy) {
                if (qty <= 0) {
                    throw new IllegalArgumentException("Quantity must be greater than 0 for buying stock.");
                }
                index.setQuantity(index.getQuantity() + qty);
            } else {
                if (qty <= 0 || qty > index.getQuantity()) {
                    throw new IllegalArgumentException("Quantity must be greater than 0 for selling stock.");
                }
                index.setQuantity(index.getQuantity() - qty);
            }
            indexRepo.save(index);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @PutMapping("/{symbol}/buyIndex/{qty}")
    public void buyStock(@PathVariable String symbol, @PathVariable int qty) {
        updateIndexQuantity(symbol, qty, true);
    }

    @PutMapping("/{symbol}/sellIndex/{qty}")
    public void sellStock(@PathVariable String symbol, @PathVariable int qty) {
        updateIndexQuantity(symbol, qty, false);
    }

}
