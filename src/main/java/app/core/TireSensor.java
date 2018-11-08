package app.core;

import java.util.ArrayList;
import java.util.List;

public class TireSensor {
	private float optimalPressure;
	
	public TireSensor() {
		this.optimalPressure = 29.3f;
	}
	
	public float getOptimalPressure( ) {
		return this.optimalPressure;
	}
	
	public List<String> checkPressure(float currentPressure, int wheels) {
		List<String> message = new ArrayList<String>();
				
		message.add("Attempting to check tire pressure.");
		
		for(int i = 0; i < wheels; i++) {
			if(this.optimalPressure > currentPressure) {
				message.add("Wheel " + (i+1) + "-> Tire pressure level: normal");
			}
		}
		
		return message;
	}
}
