package com.rahul.elevator.ElevatorSystem;

public class ElevatorController {
    private Elevator elevator;

    public ElevatorController(Elevator elevator) {
        this.elevator = elevator;
    }

    public void handleRequest(ElevatorRequest request) {
        System.out.println("Handling request at floor " + request.getFloor());
        elevator.addRequest(request.getFloor());
    }

    public void runElevator() {
        elevator.move();
    }
}

