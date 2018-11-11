package app.core;

import java.util.ArrayList;
import java.util.List;

public class SeatBeltSensor implements BinarySensor {
	
	public List<String> checkState(int itemToCheck) {
		List<String> message = new ArrayList<String>();
		message.add("Attempting to check seatbelts");
				
		while(itemToCheck > 0) {
			message.add("Checking seatbelt n° " + (itemToCheck));
			itemToCheck--;
		}
		
		return message;
	}
}
