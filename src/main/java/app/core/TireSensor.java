package app.core;

public class TireSensor {
	private float pressure;
	
	public TireSensor() {
		this.pressure = 29.3f;
	}
	
	public float getPressure( ) {
		return this.pressure;
	}
}
