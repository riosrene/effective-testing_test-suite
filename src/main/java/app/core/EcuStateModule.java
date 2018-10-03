package app.core;

public class EcuStateModule {
	private boolean ignition;
	private String stateMessage;
	
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
}
