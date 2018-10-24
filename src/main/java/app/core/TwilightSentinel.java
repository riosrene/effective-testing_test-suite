package app.core;

public class TwilightSentinel {
	
	public String informState(boolean activated) {
		if (activated) {
			return "Twilight Sensor activated.";
		} else {
			return "Twilight Sensor deactivated.";
		}
	}
}
