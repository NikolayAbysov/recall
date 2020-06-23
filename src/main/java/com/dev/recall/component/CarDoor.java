package com.dev.recall.component;

public class CarDoor {
    private boolean isDoorOpen;
    private boolean isWindowOpen;

    public boolean openDoor() {
        isDoorOpen = true;
        return true;
    }

    public boolean closeDoor() {
        isDoorOpen = false;
        return false;
    }

    public boolean actionDoor() {
        return isDoorOpen ? closeDoor() : openDoor();
    }

    public boolean openWindow() {
        isWindowOpen = true;
        return true;
    }

    public boolean closeWindow() {
        isWindowOpen = false;
        return false;
    }

    public boolean actionWindow() {
        return isWindowOpen ? closeWindow() : openWindow();
    }

    public void printDetailsToConsole() {
        System.out.println("Door details: \n" + "isDoorOpen : " + isDoorOpen + "\n"
                + "isWindowOpen : " + isWindowOpen);
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public boolean isWindowOpen() {
        return isWindowOpen;
    }
}
