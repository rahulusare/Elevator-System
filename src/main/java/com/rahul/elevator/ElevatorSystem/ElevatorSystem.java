package com.rahul.elevator.ElevatorSystem;

import java.util.Scanner;

public class ElevatorSystem {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        ElevatorController controller = new ElevatorController(elevator);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter floor number (-1 to exit): ");
            int floor = scanner.nextInt();
            if (floor == -1) break;

            System.out.print("Going up? (true/false): ");
            boolean directionUp = scanner.nextBoolean();

            controller.handleRequest(new ElevatorRequest(floor, directionUp));
            controller.runElevator();
        }

        System.out.println("Elevator system stopped.");
    }
}


