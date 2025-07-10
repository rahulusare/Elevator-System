package com.rahul.elevator.ElevatorSystem;

public class ElevatorRequest {
    private final int floor;
    private final boolean directionUp;

    public ElevatorRequest(int floor, boolean directionUp) {
        this.floor = floor;
        this.directionUp = directionUp;
    }

    public int getFloor() {
        return floor;
    }

    public boolean isDirectionUp() {
        return directionUp;
    }
}

