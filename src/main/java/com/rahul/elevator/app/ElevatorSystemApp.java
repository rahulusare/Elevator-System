package com.rahul.elevator.app;

import java.util.Scanner;

import com.rahul.elevator.controller.ElevatorController;
import com.rahul.elevator.model.ElevatorRequest;
import com.rahul.elevator.service.Elevator;
import com.rahul.elevator.util.SoundPlayer;

//import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;

public class ElevatorSystemApp {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        ElevatorController controller = new ElevatorController(elevator);
      
        Thread elevatorThread = new Thread(elevator);
  
        elevatorThread.start();
       
        
        Thread inputThread = new Thread(() -> {
        	int floor = 0;
        	String direction = null;
        	
            try (Scanner scanner = new Scanner(System.in)) {
            	System.out.println("\u001B[1m\u001B[32m========================================\u001B[0m");
            	System.out.println("\u001B[1m\u001B[32mEnter floor number (0 to 100) or -1 to Exit\u001B[0m");
            	System.out.println("\u001B[1m\u001B[32mTo call elevator:\u001B[0m");
            	System.out.println("\u001B[1m\u001B[32m  • For DOWN  =>  <floor_number\u001B[0m");
            	System.out.println("\u001B[1m\u001B[32m  • For UP    =>  >floor_number\u001B[0m");
            	System.out.println("\u001B[1m\u001B[32m========================================\u001B[0m");
                SoundPlayer.playSound("src/main/resources/sounds/EnterFloor.wav");
                while (true) {
                	String input = scanner.next().trim();
                	
                	if(input.startsWith("<") || input.startsWith(">")){
                		direction = input;
                		try {
							floor = Integer.parseInt(input.substring(1));
							   if (floor == -1) {
			                        System.out.println("\u001B[1m\u001B[31mExiting . . . \u001B[0m");
			                       
			                        elevatorThread.interrupt();
			                        break;
			                    }

			                    if (floor >= 0 && floor <= 100) {
			                        controller.handleRequest(new ElevatorRequest(floor, direction));
			                 
			                    }else {
			                    	System.out.println("\u001B[1m\u001B[31m❌ Invalid floor number in input: \u001B[0m" + input);
			                    	
			                    }

						} catch (NumberFormatException e) {
							System.out.println("\u001B[1m\u001B[31m❌ Invalid floor number in input: \u001B[0m" + input);
						}
                	}else {
                		try {
							floor = Integer.parseInt(input);
							direction = null;
							   if (floor == -1) {
			                        System.out.println("\u001B[1m\u001B[31mExiting . . . \u001B[0m");
			                     
			                        break;
			                    }

			                    if (floor >= 0 && floor <= 100) {
			                        controller.handleRequest(new ElevatorRequest(floor, direction));
			                 
			                    }else {
			                    	System.out.println("\u001B[1m\u001B[31m❌ Invalid Input: \u001B[0m" + input);
			                    	
			                    }

						} catch (NumberFormatException e) {
							System.out.println("\u001B[1m\u001B[31m❌ Invalid Input: \u001B[0m" + input);
						}
                	}
                 
                }
            }
        });

        inputThread.start();
        
        
        try {
            inputThread.join();
        } catch (InterruptedException e) {
        	 System.err.println("\u001B[1m\u001b[31m❌ Input thread was interrupted while waiting.\u001B[0m");
        	 elevatorThread.interrupt();
        }

        System.out.println("Elevator system stopped.");
        System.exit(0);
    }

}


