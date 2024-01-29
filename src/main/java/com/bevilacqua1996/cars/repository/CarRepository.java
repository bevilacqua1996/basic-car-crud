package com.bevilacqua1996.cars.repository;

import com.bevilacqua1996.cars.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<Car, Long> {
}
