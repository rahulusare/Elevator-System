package com.rahul.elevator.controller;

import com.rahul.elevator.model.ElevatorRequest;
import com.rahul.elevator.service.Elevator;

public class ElevatorController {
    private Elevator elevator;

    public ElevatorController(Elevator elevator) {
        this.elevator = elevator;
    }

    public void handleRequest(ElevatorRequest request) {
    	if(request.isDirAveleble()) {
    		System.out.println("\u001B[1m\u001B[32m ✔️ Received request for floor: \u001B[0m" + request.getDirection() + " " +request.getDirFloor());  		
    		elevator.addRequest(request.getDirection(), request.getDirFloor());
    		
    	}else {
    		System.out.println("\u001B[1m\u001B[32m You Hava Entered : \u001B[0m" + request.getFloor());
    		elevator.addRequest(request.getFloor());
    	}
    	 
    	 
    }

    public void runElevator() {
        elevator.run();
    }
}

