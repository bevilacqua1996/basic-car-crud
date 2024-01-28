package com.bevilacqua1996.cars.controller;

import com.bevilacqua1996.cars.entity.Car;
import com.bevilacqua1996.cars.entity.CarDTO;
import com.bevilacqua1996.cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping(produces = "application/json")
    public List<Car> getAllCars() {
        return carService.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public CarDTO getCarById(@PathVariable Long id) {
        return carService.findById(id);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public void updateCar(@PathVariable Long id, @RequestBody Car car) {
        car.setId(id);
        carService.update(car);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity createCar(@RequestBody CarDTO car) {
        carService.create(Car.fromDTO(car));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.delete(id);
    }
}
