package com.example.portfolio.model.repository;

import com.example.portfolio.model.ETF;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ETFRepository extends MongoRepository<ETF,String> {
}
