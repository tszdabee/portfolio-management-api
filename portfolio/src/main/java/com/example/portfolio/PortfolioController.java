package com.example.portfolio;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PortfolioController {

    @GetMapping(value="/portfolio", produces={"application/json", "application/xml"})

    public Stock getStock(){
        return new Stock("1", "RBC", 2.00, 43.0, 10000.0);
    }
}
