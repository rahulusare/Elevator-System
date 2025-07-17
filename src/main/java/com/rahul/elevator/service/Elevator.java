package com.rahul.elevator.service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.rahul.elevator.model.FloorRequests;
import com.rahul.elevator.util.SoundPlayer;
import com.rahul.elevator.util.Utils;

public class Elevator implements Runnable {
    private int currentFloor=0;
  //  private int personCount;
   
   // int nextFloor2;
    
       
    BlockingQueue<Integer> inRequests = new LinkedBlockingQueue<>();
    BlockingQueue<FloorRequests> outRequests = new LinkedBlockingQueue<>();
    

    public Elevator() {
    		this.currentFloor = 0;
    }
  
    public void addRequest(char direction, int dirFloor) {
        outRequests.add(new FloorRequests(direction, dirFloor));
       

    }
    public void addRequest(int floor) {
    	inRequests.add(floor);
    	
    }
 
    @Override
    public void run() {
        while (true) {
           if(!inRequests.isEmpty()) {
        	   try {
				int nextFloor = inRequests.take();
				move(nextFloor);
			   } catch (InterruptedException e) {
				e.printStackTrace();
			   }
           }else if(!outRequests.isEmpty()) {
        	   try {
				FloorRequests fr = outRequests.take();
				move(fr.getFloor());
			   } catch (InterruptedException e) {
				e.printStackTrace();
			   }
           }else {
        	   Utils.sleep(500);
           }
        }
    }
    
    
    public void move(int nextFloor) {
    	if(currentFloor < nextFloor) {
    		System.out.println("\u001B[1m\u001B[32m 🔼 Going Up to: \u001B[0m" +nextFloor);
    		SoundPlayer.playSound("src/main/resources/sounds/Up.wav");
    		
    		for(int i=currentFloor; i<= nextFloor;i++) {
    			System.out.printf("\u001B[1m\u001B[31m   🔼 %2d\u001B[0m\n", i);
    			//currentFloor += 1;
    			currentFloor++;
    			if(checkIfFloorGoingUp(i)) {
    				SoundPlayer.playSound("src/main/resources/sounds/AtFloor.wav");
    				DoorOpen();
    				
    				//currentFloor = nextFloor;
    				System.out.println("In_Requests_Pending: "+inRequests.size()+"\nOut_Request_Pending: "+ outRequests.size()+"\nCurrent_Floor: "+ currentFloor);
    				
    			}
    		
    			Utils.sleep(1000);
    		}
			
    	}else if(currentFloor == nextFloor){
    		//System.out.println("We are alredy at floor: "+ currentFloor);
    		
    	}else {
    		System.out.println("\u001B[1m\u001B[32m 🔽 Going Down to \u001B[0m"+ nextFloor);
    		SoundPlayer.playSound("src/main/resources/sounds/Down.wav");
    		
    		for(int i=currentFloor; i>= nextFloor;i--) {
    			System.out.printf("\u001B[1m\u001B[31m   🔽 %2d\u001B[0m\n", i);
    			currentFloor--;
    			if(checkIfFloorGoingDown(i)) {
    				SoundPlayer.playSound("src/main/resources/sounds/AtFloor.wav");
    				DoorOpen();
    				//currentFloor = nextFloor;
    				System.out.println("In_Requests_Pending: "+inRequests.size()+"\nOut_Request_Pending: "+ outRequests.size()+"\nCurrent_Floor: "+ currentFloor);
    			
    				
    			}
    			Utils.sleep(1000);
    		}
    		
    	}
    	
    	SoundPlayer.playSound("src/main/resources/sounds/AtFloor.wav");
    	DoorOpen();

    	//currentFloor = nextFloor;
    	System.out.println("In_Requests_Pending: "+inRequests.size()+"\nOut_Request_Pending: "+ outRequests.size()+"\nCurrent_Floor: "+ currentFloor);
       
    }
    
    public boolean checkIfFloorGoingUp(int floor) {
    	//FloorRequests fr;
    	for(FloorRequests fr : outRequests) {
    		if(fr.getFloor() == floor) {
    			if(fr.getDirection() == '>') {
    				outRequests.remove(fr);
    				return true;
    			}
    		}
    		//nextFloor2 = fr.getFloor();
    		
    	}
    
		return false;
    	
    }
    
    public boolean checkIfFloorGoingDown(int floor) {
    	for (FloorRequests fr : outRequests) {
    		if(fr.getFloor() == floor) {
    			if(fr.getDirection() == '<') {
    				outRequests.remove(fr);
    				return true;
    			}
    		}
    		//nextFloor2 = fr.getFloor();
    	}
    	return false;
    }
    
    public static void DoorOpen() {
    	System.out.println("\u001B[1m\u001B[32m 🚪 Door opening... \u001B[0m");
    	SoundPlayer.playSound("src/main/resources/sounds/DoubleDing.wav");
        Utils.sleep(1000);
        System.out.println("\u001B[1m\u001B[32m 🔒 Door closed \u001B[0m");
        //System.out.println(totleRequests);
       
    }
    
    
   
	public int getCurrentFloor() {
		return currentFloor;
	}
	
		
}

