package virtualecu.output;

public class FuelInjector {
	private boolean voltageOff;
	private String state;
	
	public FuelInjector(boolean voltageOff) {
		this.voltageOff = voltageOff;
		state = "fuel injector closed";
	}
	
	public void interruptVoltage() {
		voltageOff = true;
	}
	
	public void inject(float pressure) {
		if (voltageOff == true) {
			if (pressure <= 2.5f) {
				state = "injecting fuel";
			} else {
				state = "injecting fuel, full capacity";
			}
			
		}
	}
	
	public String getState() {
		return state;
	}
}
