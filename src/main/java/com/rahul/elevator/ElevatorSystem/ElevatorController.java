package com.rahul.elevator.ElevatorSystem;

public class ElevatorController {
    private Elevator elevator;

    public ElevatorController(Elevator elevator) {
        this.elevator = elevator;
    }

    public void handleRequest(ElevatorRequest request) {
        elevator.addRequest(request.getFloor());
    }

    public void runElevator() {
        elevator.move();
    }
}

