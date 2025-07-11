package com.rahul.elevator.app;

import java.util.Scanner;

import com.rahul.elevator.controller.ElevatorController;
import com.rahul.elevator.model.ElevatorRequest;
import com.rahul.elevator.service.Elevator;
import com.rahul.elevator.util.SoundPlayer;

public class ElevatorSystemApp {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        ElevatorController controller = new ElevatorController(elevator);
        
        Thread elevatorThread = new Thread(elevator);
        elevatorThread.start();
        
        Thread inputThread = new Thread(() -> {
            try (Scanner scanner = new Scanner(System.in)) {
            	System.out.println("\u001B[1m\u001B[32mEnter floor number 0 to 49 (-1 for Exit): \u001B[0m");
                SoundPlayer.playSound("src/main/resources/sounds/EnterFloor.wav");
                while (true) {
                    if (!scanner.hasNextInt()) {
                        scanner.next(); // skip junk input
                        continue;
                    }

                    int floor = scanner.nextInt();
                    if (floor == -1) {
                        System.out.println("Exiting...");
                        elevatorThread.interrupt();
                        break;
                    }

                    if (floor >= 0 && floor <= 49) {
                        controller.handleRequest(new ElevatorRequest(floor));
                    } else {
                        System.out.println("Invalid floor!");
                    }
                }
            }
        });

        inputThread.start();
        
        
        try {
            inputThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Elevator system stopped.");
        System.exit(0);
    }

}


