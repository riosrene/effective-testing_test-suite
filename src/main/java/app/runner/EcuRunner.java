package app.runner;

import app.core.EcuStateModule;
import app.core.IgnitionAdvanceSensor;
import app.core.RpmSensor;

public class EcuRunner {
	
	public static void main (String[] args) {
		EcuStateModule ecuState = new EcuStateModule();
		IgnitionAdvanceSensor ignitionAdvanceSensor = new IgnitionAdvanceSensor();
		RpmSensor rpmSensor = new RpmSensor();

		ecuState.ignition = true;
		ignitionAdvanceSensor.angle = 40;
		rpmSensor.currentRpm = 700;
		
		System.out.println("Engine started.");
		System.out.println("===============");
		System.out.println("Engine RPM: " + rpmSensor.currentRpm);
	}

}
