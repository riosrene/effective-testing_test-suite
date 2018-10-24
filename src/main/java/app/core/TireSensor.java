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
		
		String message = new String();
		
		switch (Math.round(currentPressure) / 10) {
		  	case 1:
		  		message = "Tire pressure level is low. ";
		  		break;
		  	case 2:
		  		message = "Tire pressure level is normal. ";
		  		break;
		  	case 3:
		  		message = "Tire pressure level is high. ";
	  	}
		
		return message;
		
	}
	
}
