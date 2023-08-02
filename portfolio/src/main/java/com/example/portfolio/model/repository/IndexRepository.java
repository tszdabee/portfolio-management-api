package com.example.portfolio.model.repository;

import com.example.portfolio.model.Index;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IndexRepository extends MongoRepository<Index,String> {
}
