package com.rahul.elevator.ElevatorSystem;

import java.util.*;

public class Elevator {
    private int currentFloor;
    private boolean goingUp;
    private boolean goingDown;
    
    Queue<Integer> requests = new LinkedList<>();
   // private List<Integer> requests = new ArrayList<>();
    int[] floors = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public Elevator() {
    		this.currentFloor = 0;
    		this.goingUp = true;
    		this.goingDown = false;
    }

    public void addRequest(int floor) {
       requests.add(floor);
    	
    	
    }
    
    public void move() {
        if (!requests.isEmpty()) {
        	int nextFloor = requests.poll();
    
        	if(currentFloor < nextFloor) {
        		System.out.println("🔼 Going Up to " +nextFloor);
        		
        		for(int i=currentFloor; i<= nextFloor;i++) {
        			System.out.println("🔼" + i);
        			Utils.sleep(1000);
        		}
        		
        	}else {
        		System.out.println("🔽 Goinng down to: "+ nextFloor);
        		
        		for(int i=currentFloor; i>= nextFloor;i--) {
        			System.out.println("🔽 " + i);
        			Utils.sleep(1000);
        		}	
        	}
        	System.out.println("Open Door");
        	Utils.sleep(100);
        	System.out.println("Close Door");
            currentFloor = nextFloor;
        }else {
            System.out.println("No requests.");
        }
    }
    
   
    public int getCurrentFloor() {
        return currentFloor;
    }
}

