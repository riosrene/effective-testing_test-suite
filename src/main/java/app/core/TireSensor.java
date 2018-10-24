package app.core;

public class TireSensor {
	private float optimalPressure;
	
	public TireSensor() {
		this.optimalPressure = 29.3f;
	}
	
	public float getOptimalPressure( ) {
		return this.optimalPressure;
	}
	
	public String checkPressure(float currentPressure) {
		
		if (currentPressure < optimalPressure) {
			return "Tire pressure level is low.";
		} else {
			return "Tire pressure level is normal.";
		}
		
	}
}
