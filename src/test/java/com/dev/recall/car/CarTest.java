package com.dev.recall.car;

import com.dev.recall.exception.InvalidArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class CarTest {
    private static Car car;

    @BeforeAll
    static void setUp() {
        car = new Car();
    }

    @Test
    void changeCurrentSpeedOk() {
        car.setMaxSpeed(100);
        Assertions.assertEquals(50, car.changeCurrentSpeed(50));
        Assertions.assertEquals(25, car.changeCurrentSpeed(-25));
    }

    @Test
    void changeCurrentSpeedNotOk() {
        car.setMaxSpeed(100);
        Assertions.assertThrows(InvalidArgumentException.class, () -> {
            car.changeCurrentSpeed(200);
        });
        Assertions.assertThrows(InvalidArgumentException.class, () -> {
            car.changeCurrentSpeed(-200);
        });
    }

    @Test
    void addPassengerOk() {
        car.setMaxPassengers(5);
        car.addPassenger();
        Assertions.assertEquals(1, car.getCurrentPassengersNum());
    }

    @Test
    void addPassengerNotOk() {
        Assertions.assertThrows(InvalidArgumentException.class, () -> {
            car.addPassenger();
        });
    }

    @Test
    void detractPassengerOk() {
        car.setMaxPassengers(5);
        car.addPassenger();
        car.detractPassenger();
        Assertions.assertEquals(0, car.getCurrentPassengersNum());
    }

    @Test
    void detractPassengerNotOk() {
        Assertions.assertThrows(InvalidArgumentException.class, () -> {
            car.detractPassenger();
        });
    }

    @Test
    void getPassengersOutOk() {
        car.setMaxPassengers(2);
        car.addPassenger();
        car.addPassenger();
        Assertions.assertEquals(0, car.getPassengersOut());
    }

    @Test
    void addWheelsOk() {
        car.addWheels(5);
        Assertions.assertEquals(5, car.getWheels().length);
    }

    @Test
    void addWheelsNotOk() {
        Assertions.assertThrows(InvalidArgumentException.class, () -> {
            car.addWheels(-5);
        });
    }

    @Test
    void takeAllCarWheelsOffOk() {
        car.addWheels(5);
        car.takeAllCarWheelsOff();
        Assertions.assertEquals(0, car.getWheels().length);
    }
}