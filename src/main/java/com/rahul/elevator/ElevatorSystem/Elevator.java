package com.rahul.elevator.ElevatorSystem;

import java.util.*;

public class Elevator {
    private int currentFloor = 0;
    private boolean goingUp = true;
    private List<Integer> requests = new ArrayList<>();

    public void addRequest(int floor) {
        if (!requests.contains(floor)) {
            requests.add(floor);
        }
    }

    public void move() {
        if (!requests.isEmpty()) {
            int nextFloor = requests.remove(0);
            System.out.println("Moving from floor " + currentFloor + " to " + nextFloor);
            currentFloor = nextFloor;
        } else {
            System.out.println("No requests.");
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}

