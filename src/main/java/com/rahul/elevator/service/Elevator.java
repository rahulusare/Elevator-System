package com.rahul.elevator.service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.rahul.elevator.util.SoundPlayer;
import com.rahul.elevator.util.Utils;

public class Elevator implements Runnable {
    private int currentFloor;
       
    BlockingQueue<Integer> requests = new LinkedBlockingQueue<>();
    

    public Elevator() {
    		this.currentFloor = 0;
    }
  
    public void addRequest(int floor) {
       requests.add(floor);

    }
    
    @Override
    public void run() {
        while (true) {
            if (!requests.isEmpty()) {
                int nextFloor = 0;
				try {
					nextFloor = requests.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
                move(nextFloor);
            } else {
                Utils.sleep(500);
            }
        }
    }
    
    
    public void move(int nextFloor) {
    	if(currentFloor < nextFloor) {
    		System.out.println("\u001B[1m\u001B[32m 🔼 Going Up to: \u001B[0m" +nextFloor);
    		SoundPlayer.playSound("src/main/resources/sounds/Up.wav");
    		
    		for(int i=currentFloor; i<= nextFloor;i++) {
    			System.out.println("\u001B[1m\u001B[31m   🔼 \u001B[0m" + i);
    			if(requests.contains(i)) {
    				requests.remove(i);
    				SoundPlayer.playSound("src/main/resources/sounds/AtFloor.wav");
    				DoorOpen();
    				
    			}
    			Utils.sleep(1000);
    		}
			
    	}else if(currentFloor == nextFloor){
    		//System.out.println("We are alredy at floor: "+ currentFloor);
    		
    	}else {
    		System.out.println("\u001B[1m\u001B[32m 🔽 Going Down to \u001B[0m"+ nextFloor);
    		SoundPlayer.playSound("src/main/resources/sounds/Down.wav");
    		
    		for(int i=currentFloor; i>= nextFloor;i--) {
    			System.out.println("\u001B[1m\u001B[31m   🔽 \u001B[0m\"" + i);
    			if(requests.contains(i)) {
    				requests.remove(i);
    				SoundPlayer.playSound("src/main/resources/sounds/AtFloor.wav");
    				DoorOpen();
    				
    			}
    			Utils.sleep(1000);
    		}
    		
    	}

    	SoundPlayer.playSound("src/main/resources/sounds/AtFloor.wav");
    	DoorOpen();
    	while(requests.isEmpty()) {
    		SoundPlayer.playSound("src/main/resources/sounds/EnterFloor.wav");
    	}
    	currentFloor = nextFloor;
       
    }
    
    public static void DoorOpen() {
    	SoundPlayer.playSound("src/main/resources/sounds/DoubleDing.wav");
        System.out.println("\u001B[1m\u001B[32m 🚪 Door opening... \u001B[0m");
        Utils.sleep(1000);
        System.out.println("\u001B[1m\u001B[32m 🔒 Door closed \u001B[0m");
    }
    
    
   
	public int getCurrentFloor() {
		return currentFloor;
	}
		
}

