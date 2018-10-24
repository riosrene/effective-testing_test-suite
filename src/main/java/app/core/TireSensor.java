package app.core;

public class TireSensor {
	private float optimalPressure;
	
	public TireSensor() {
		this.optimalPressure = 29.3f;
	}
	
	public float getOptimalPressure( ) {
		return this.optimalPressure;
	}
}
