package com.rahul.elevator.ElevatorSystem;

import java.util.Scanner;

public class ElevatorSystem {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        ElevatorController controller = new ElevatorController(elevator);
        try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    System.out.print("Enter floor number 0 to 9 (-1 for Exit): ");
			    int floor = scanner.nextInt();
			    
			    if (floor < 0 || floor > 9) {
		            System.out.println("Invalid floor!");
		         
		        }
			    if(floor == -1) {
			    	break;
			    }
			    if(floor >=0 && floor <=9) {
			    	controller.handleRequest(new ElevatorRequest(floor /*,directionUp*/));
			    	controller.runElevator();
			    }
			}
		}

        System.out.println("Elevator system stopped.");
    }
}


