package com.dev.recall.component;

import com.dev.recall.exception.InvalidArgumentException;

public class CarWheel {
    private float status;

    public CarWheel() {
        this.status = 1F;
    }

    public float changeToNew() {
        status = 1F;
        return status;
    }

    public float wearOut(float percent) {
        if (percent > 1F) {
            throw new InvalidArgumentException("Percent can't be more than 1");
        }
        status = status - percent;
        return status;
    }

    public void printDetailsToConsole() {
        System.out.println("Wheel details: \n" + "Status : " + status);
    }

    public float getStatus() {
        return status;
    }

    public void setStatus(float status) {
        this.status = status;
    }
}
