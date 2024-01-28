package com.bevilacqua1996.cars.service;


import com.bevilacqua1996.cars.entity.Car;
import com.bevilacqua1996.cars.entity.CarDTO;
import com.bevilacqua1996.cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public CarDTO findById(Long id) {

        Optional<Car> car = carRepository.findById(id);

        return car.map(Car::toDTO).orElse(null);
    }

    public void create(Car car) {
        carRepository.save(car);
    }

    public void update(Car car) {
        Optional<Car> carEntity = carRepository.findById(car.getId());

        if(carEntity.isPresent()) {
            Car carEntityNew = carEntity.get();
            carEntityNew.setBrand(car.getBrand());
            carEntityNew.setColor(car.getColor());
            carEntityNew.setKilometers(car.getKilometers());
            carEntityNew.setModel(car.getModel());
            carEntityNew.setPrice(car.getPrice());
            carEntityNew.setReleaseDate(car.getReleaseDate());

            carRepository.save(carEntityNew);
        }

    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }

}
