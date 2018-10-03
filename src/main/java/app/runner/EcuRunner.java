package app.runner;

import app.core.EcuStateModule;
import app.core.IgnitionAdvanceSensor;
import app.core.RpmSensor;
import app.core.TireSensor;

public class EcuRunner {
	
	public static void main (String[] args) {
		EcuStateModule ecuState = new EcuStateModule();
		IgnitionAdvanceSensor ignitionAdvanceSensor = new IgnitionAdvanceSensor();
		RpmSensor rpmSensor = new RpmSensor();
		TireSensor tireSensor = new TireSensor();
		
		ecuState.setIgnition(true);
		ignitionAdvanceSensor.setAngle(40);
		rpmSensor.setCurrentRpm(700);
		
		System.out.println(ecuState.getStateMessage());
		System.out.println("===============");
		System.out.println("Engine RPM: " + rpmSensor.getCurrentRpm());
		System.out.println("Tire pressure level: " + tireSensor.getPressure());
	}

}
