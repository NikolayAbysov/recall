package com.dev.recall.car;

import com.dev.recall.component.CarDoor;
import com.dev.recall.component.CarWheel;
import com.dev.recall.exception.InvalidArgumentException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Car {
    private final LocalDate manufactureDate;
    private String engineType;
    private int maxSpeed;
    private int timeToMaxSpeed;
    private int maxPassengers;
    private int currentPassengersNum;
    private int currentSpeed;
    private CarWheel[] wheels;
    private CarDoor[] doors;

    public Car() {
        this.manufactureDate = LocalDate.now();
        this.wheels = new CarWheel[0];
        this.doors = new CarDoor[0];
    }

    public int changeCurrentSpeed(int value) {
        if (value < 0 && Math.abs(value) > currentSpeed) {
            throw new InvalidArgumentException("Change speed value is greater than current speed");
        } else if (value + currentSpeed > maxSpeed) {
            throw new InvalidArgumentException("Change speed value is greater than current speed");
        }
        currentSpeed = currentSpeed + value;
        return currentSpeed;
    }

    public int addPassenger() {
        if (currentPassengersNum + 1 > maxPassengers) {
            throw new InvalidArgumentException("Number of passengers exceeds max limit");
        }
        currentPassengersNum = currentPassengersNum + 1;
        return currentPassengersNum;
    }

    public int detractPassenger() {
        if (currentPassengersNum - 1 < 0) {
            throw new InvalidArgumentException("Number of passengers exceeds min limit");
        }
        currentPassengersNum = currentPassengersNum - 1;
        return currentPassengersNum;
    }

    public int getPassengersOut() {
        currentPassengersNum = 0;
        return currentPassengersNum;
    }

    public CarDoor getCarDoorByIndex(int index) {
        return doors[index];
    }

    public CarWheel getCarWheelByIndex(int index) {
        return wheels[index];
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public boolean takeAllCarWheelsOff() {
        wheels = new CarWheel[0];
        return true;
    }

    public CarWheel[] addWheels(int value) {
        if (value < 0) {
            throw new InvalidArgumentException("Value can't be negative");
        }
        List<CarWheel> carWheelList = Arrays.stream(wheels)
                .collect(Collectors
                        .toList());
        for (int i = 0; i < value; i++) {
            carWheelList.add(new CarWheel());
        }
        wheels = carWheelList.toArray(new CarWheel[0]);;
        return wheels;
    }

    public int getPossibleMaxSpeed() {
        if (currentPassengersNum == 0) {
            return 0;
        }
        Optional<CarWheel> wheel = Arrays.stream(wheels)
                .min(Comparator
                        .comparing(CarWheel::getStatus));
        if (wheel.isEmpty()) {
            return 0;
        }
        return (int) (maxSpeed * wheel.get().getStatus());
    }

    public void printDetailsToConsole() {
        System.out.println("Car{"
                + "manufactureDate=" + manufactureDate
                + ", \nengineType='" + engineType + '\''
                + ", \nmaxSpeed=" + maxSpeed
                + ", \ntimeToMaxSpeed=" + timeToMaxSpeed
                + ", \nmaxPassengers=" + maxPassengers
                + ", \ncurrentPassengersNum=" + currentPassengersNum
                + ", \ncurrentSpeed=" + currentSpeed
                + ", \nwheels=" + wheels.length
                + ", \ndoors=" + doors.length
                + ", \ncurrent possible max speed=" + getPossibleMaxSpeed()
                + '}');
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getTimeToMaxSpeed() {
        return timeToMaxSpeed;
    }

    public void setTimeToMaxSpeed(int timeToMaxSpeed) {
        this.timeToMaxSpeed = timeToMaxSpeed;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public int getCurrentPassengersNum() {
        return currentPassengersNum;
    }

    public void setCurrentPassengersNum(int currentPassengersNum) {
        this.currentPassengersNum = currentPassengersNum;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public CarWheel[] getWheels() {
        return wheels;
    }

    public void setWheels(CarWheel[] wheels) {
        this.wheels = wheels;
    }

    public CarDoor[] getDoors() {
        return doors;
    }

    public void setDoors(CarDoor[] doors) {
        this.doors = doors;
    }
}
