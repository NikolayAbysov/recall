package com.dev.recall.component;

import com.dev.recall.exception.InvalidArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CarWheelTest {
    private static CarWheel carWheel;

    @BeforeAll
    static void setUp() {
        carWheel = new CarWheel();
    }

    @Test
    void wearOutOk() {
        Assertions.assertEquals(0.5F, carWheel.wearOut(0.5F));
    }

    @Test
    void wearOutNotOk() {
        Assertions.assertThrows(InvalidArgumentException.class, () -> {
            carWheel.wearOut(2F);
        });
    }

    @Test
    void changeToNewOk() {
        carWheel.wearOut(0.5F);
        Assertions.assertEquals(0.5F, carWheel.getStatus());
        carWheel.changeToNew();
        Assertions.assertEquals(1F, carWheel.getStatus());
    }
}
