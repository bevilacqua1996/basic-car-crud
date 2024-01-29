package com.bevilacqua1996.cars.controller;

import com.bevilacqua1996.cars.entity.Car;
import com.bevilacqua1996.cars.entity.CarDTO;
import com.bevilacqua1996.cars.service.CarService;
import com.bevilacqua1996.cars.service.SequenceGeneratorService;
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

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @GetMapping(produces = "application/json")
    public List<Car> getAllCars() {
        return carService.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CarDTO> getCarById(@PathVariable Long id) {
        CarDTO carDTO = carService.findById(id);
        if(carDTO==null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(carDTO);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public void updateCar(@PathVariable Long id, @RequestBody Car car) {
        car.setId(id);
        carService.update(car);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> createCar(@RequestBody CarDTO car) {
        Car carEntity = Car.fromDTO(car);
        carEntity.setId(sequenceGeneratorService.generateSequence(Car.SEQUENCE_NAME));
        carService.create(carEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
