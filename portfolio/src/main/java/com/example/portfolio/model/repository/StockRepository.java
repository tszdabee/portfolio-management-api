package com.example.portfolio.model.repository;

import com.example.portfolio.model.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockRepository extends MongoRepository<Stock,String> {
}
