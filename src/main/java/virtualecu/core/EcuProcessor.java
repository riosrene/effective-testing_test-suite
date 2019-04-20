package virtualecu.core;

import virtualecu.input.BS;
import virtualecu.input.MAP;
import virtualecu.input.TPS;
import virtualecu.output.FuelInjector;

public class EcuProcessor {
	private boolean voltageOn = true;		
	private FuelInjector injector = new FuelInjector(voltageOn);
	private String airDensity;
	
	public String measureAirDensity(MAP map, BS bs) {
		int airDensityDiff = Math.round(map.getHg() - bs.getHg());
		
		switch (airDensityDiff) {
		case 0: case 1:
			airDensity = "low";
			break;
		case 2: case 3:
			airDensity = "normal";
			break;
		case 4:
			airDensity = "high";
			break;
		default:
			airDensity = "failed";
		}
		
		return airDensity;
	}
	
	public void dosifyFuel(TPS tps) {
		switch(airDensity) {
		case "low":
			if (tps.getAngle() >= 50) {
				injectFuel(1.8f);
			} else {
				injectFuel(1.9f);
			}
			break;
		case "normal":
			if (tps.getAngle() >= 50) {
				injectFuel(2.4f);
			} else {
				injectFuel(2.8f);
			}
			break;
		case "high":
			if (tps.getAngle() >= 50) {
				injectFuel(3.1f);
			} else {
				injectFuel(3.3f);
			}
		default:
			//todo set injector closed.
		}
	}
	
	public String getInjectorState() {
		return injector.getState();
	}
	
	private void injectFuel(float fuelDosis) {
		injector.interruptVoltage();
		injector.inject(fuelDosis);
	}

}
