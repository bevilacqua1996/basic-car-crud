package com.bevilacqua1996.cars.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "cars")
public class Car {

    @Transient
    public static final String SEQUENCE_NAME = "cars_sequence";

    @Id
    private Long id;

    private String brand;
    private LocalDate releaseDate;
    private String model;
    private String color;
    private String kilometers;
    private Double price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getKilometers() {
        return kilometers;
    }

    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public static Car fromDTO(CarDTO carDTO) {
        Car car = new Car();
        car.setBrand(carDTO.getBrand());
        car.setColor(carDTO.getColor());
        car.setKilometers(carDTO.getKilometers());
        car.setModel(carDTO.getModel());
        car.setPrice(carDTO.getPrice());
        car.setReleaseDate(carDTO.getReleaseDate());
        return car;
    }

    public static CarDTO toDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setBrand(car.getBrand());
        carDTO.setColor(car.getColor());
        carDTO.setKilometers(car.getKilometers());
        carDTO.setModel(car.getModel());
        carDTO.setPrice(car.getPrice());
        carDTO.setReleaseDate(car.getReleaseDate());
        return carDTO;
    }
}