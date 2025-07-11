package com.rahul.elevator.util;

public class Utils {
	
	public static void sleep(long ml) {
		try {
			Thread.sleep(ml);;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
