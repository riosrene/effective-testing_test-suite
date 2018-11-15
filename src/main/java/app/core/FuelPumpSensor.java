package app.core;

public class FuelPumpSensor extends Sensor {
	
	public String showFuelConsumption(String mode) {
		String message = "MODE NOT DEFINED.";
		
		if (mode.equals("sport")) {
			message = "fuel consumption: High";
		} 
		if (mode.equals("normal")) {
			message = "fuel consumption: Normal";
		}
		
		return message;
	}
}
