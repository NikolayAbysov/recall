package com.dev.recall.component;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarDoorTest {
    private static CarDoor carDoor;

    @BeforeAll
    static void setUp() {
        carDoor = new CarDoor();
    }

    @Test
    void openDoorOk() {
        assertTrue(carDoor.openDoor());
    }

    @Test
    void closeDoorOk() {
        assertFalse(carDoor.closeDoor());
    }

    @Test
    void openWindowOk() {
        assertTrue(carDoor.openWindow());
    }

    @Test
    void closeWindowOk() {
        assertFalse(carDoor.closeWindow());
    }

    @Test
    void ActionDoorOk() {
        carDoor.closeDoor();
        assertFalse(carDoor.isDoorOpen());
        carDoor.actionDoor();
        assertTrue(carDoor.isDoorOpen());
    }

    @Test
    void ActionWindowOk() {
        carDoor.closeWindow();
        assertFalse(carDoor.isWindowOpen());
        carDoor.actionWindow();
        assertTrue(carDoor.isWindowOpen());
    }
}