package com.bevilacqua1996.cars;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(webEnvironment = DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarsEndpointsIT extends CarsPropertiesIntegrationTest {

    @Test
    @Order(1)
    public void testGetAllCars() {
        given()
                .when().get("/cars")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }

    @Test
    @Order(2)
    public void testCreateCar() {
        given()
                .when()
                .body("{\n" +
                        "\t\"brand\":\"Opel\",\n" +
                        "    \"releaseDate\":\"2021-01-01\",\n" +
                        "    \"model\":\"Astra\",\n" +
                        "    \"color\":\"Red\",\n" +
                        "    \"kilometers\":\"1234\",\n" +
                        "    \"price\":12000\n" +
                        "}")
                .contentType("application/json")
                .post("/cars")
                .then()
                .statusCode(201);
    }


    @Test
    @Order(3)
    public void testGetCar() {
        given()
                .when().get("/cars/1")
                .then()
                .statusCode(200)
                .body(is("{\"brand\":\"Opel\",\"releaseDate\":\"2021-01-01\",\"model\":\"Astra\",\"color\":\"Red\",\"kilometers\":\"1234\",\"price\":12000.0}"));
    }

    @Test
    @Order(4)
    public void testGetCarNotFound() {
        given()
                .when().get("/cars/2")
                .then()
                .statusCode(204);
    }


    @Test
    @Order(5)
    public void testDeleteCar() {
        given()
                .when()
                .delete("/cars/1")
                .then()
                .statusCode(204);
    }

}
