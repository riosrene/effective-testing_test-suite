package app.core;

import java.util.ArrayList;
import java.util.List;

public class TireSensor extends Sensor implements BinarySensor {
	private float optimalPressure;
	private float currentPressure;
	
	public TireSensor() {
		this.optimalPressure = 29.3f;
	}
	
	public float getOptimalPressure( ) {
		return this.optimalPressure;
	}
	
	public void setCurrentPressure(float currentPressure) {
		this.currentPressure = currentPressure;
	}
	
	public List<String> checkState(int itemToCheck) {
		List<String> message = new ArrayList<String>();
		
		message.add("Attempting to check tire pressure.");

		while(itemToCheck > 0) {
			if(this.optimalPressure > currentPressure) {
				message.add("Wheel " + (itemToCheck) + "-> Tire pressure level: normal");
			}
			itemToCheck--;
		}

		return message;
	}
}
