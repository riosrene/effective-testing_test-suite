package app.core;

public class EcuStateModule {
	private boolean ignition;
	private String stateMessage;
	private float currentTirePressure;
	private boolean twilightSentinelActivated;
	
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
	
	public boolean isTwilightSentinelActivated() {
		return twilightSentinelActivated;
	}

	public void setTwilightSentinelState(boolean activated) {
		this.twilightSentinelActivated = activated;
	}
	
}
