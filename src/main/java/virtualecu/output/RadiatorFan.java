package virtualecu.output;

public class RadiatorFan {
	private boolean turnedOn;
	
	public RadiatorFan() {
		this.turnedOn = false;
	}
	
	public boolean isTurnedOn() {
		return turnedOn;
	}

	public void setTurnedOn(boolean turnedOn) {
		this.turnedOn = turnedOn;
	}

}
