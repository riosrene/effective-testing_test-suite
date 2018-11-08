package app.core;

public class EcuStateModule {
	private boolean ignition;
	private String stateMessage;
	private float currentTirePressure;
	private int doors;
	
	public EcuStateModule() {
		this.stateMessage = "ECU started.";
	}
	
	public boolean IgnitionActivated() {
		return ignition;
	}

	public void setIgnition(boolean ignition) {
		this.ignition = ignition;
	}
	
	public String getStateMessage() {
		return this.stateMessage;
	}

	public float getCurrentTirePressure() {
		return currentTirePressure;
	}

	public void setCurrentTirePressure(float currentTirePressure) {
		this.currentTirePressure = currentTirePressure;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}
	
}
