package com.rahul.elevator.model;

public class FloorRequests {
	int dirFloor;
	char direction;
	
	
	public FloorRequests(char direction, int dirFloor) {
		this.direction = direction;
		this.dirFloor = dirFloor;
	}


	public int getFloor() {
		return dirFloor;
	}

	public char getDirection() {
		return direction;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;

	    FloorRequests other = (FloorRequests) obj;

	    return this.dirFloor == other.dirFloor && this.direction == other.direction;
	}

	@Override
	public int hashCode() {
	    int result = Integer.hashCode(dirFloor);
	    result = 31 * result + Character.hashCode(direction); // use Character.hashCode
	    return result;
	}


}
