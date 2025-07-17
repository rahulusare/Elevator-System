package com.rahul.elevator.model;

public class ElevatorRequest {
    private int floor = 0;
    private char direction;
    private int dirFloor = 0;
    private String dirAveleble = null;
  
	public ElevatorRequest(int floor, String direction) {
		
        this.floor = floor;
        if(direction != null) {
        	this.dirAveleble = direction;
        	this.direction = direction.charAt(0);
        	this.dirFloor = Integer.parseInt(direction.substring(1));      	
        }
        
     
    }
	
	

    public int getFloor() {
        return floor;
    }
    
    public char getDirection() {
    	return direction;
    }
    
    public int getDirFloor() {
    	return dirFloor;
    }
 
    
    public boolean isDirAveleble() {
    	if(dirAveleble != null) {
    		return true;
    	}
		return false;
    	
    }


}

