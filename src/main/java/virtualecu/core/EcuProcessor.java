package virtualecu.core;

import virtualecu.input.TPS;
import virtualecu.output.FuelInjector;

public class EcuProcessor {
	private boolean voltageOn = true;		
	private FuelInjector injector = new FuelInjector(voltageOn);
	
	
	public void dosifyFuel(TPS tps) {
		if (tps.getAngle() >= 50) {
			injector.interruptVoltage();
			injector.inject(2.4f);
		} else {
			injector.interruptVoltage();
			injector.inject(2.8f);
		}
	}
	
	public String getInjectorState() {
		return injector.getState();
	}
}
