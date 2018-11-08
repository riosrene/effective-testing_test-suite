package app.core;

import java.util.ArrayList;
import java.util.List;

public class DoorSensor {
	public List<String> checkDoors(int doors) {
		List<String> message = new ArrayList<String>();
		
		message.add("Attempting to check the doors.");
		
		for(int i = 0; i < doors; i++) {
			message.add("Door " + (i+1) + " checked.");
		}
		
		return message;
	}
}
