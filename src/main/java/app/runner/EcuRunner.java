package app.runner;

import app.core.EcuStateModule;
import app.core.IgnitionAdvanceSensor;
import app.core.RpmSensor;
import app.core.TireSensor;
import app.core.TwilightSentinel;

public class EcuRunner {
	
	public static void main (String[] args) {
		EcuStateModule ecuState = new EcuStateModule();
		IgnitionAdvanceSensor ignitionAdvanceSensor = new IgnitionAdvanceSensor();
		RpmSensor rpmSensor = new RpmSensor();
		TireSensor tireSensor = new TireSensor();
		TwilightSentinel twilightSentinel = new TwilightSentinel();
		
		ecuState.setIgnition(true);
		ignitionAdvanceSensor.setAngle(40);
		ecuState.setCurrentTirePressure(19.9f);
		rpmSensor.setCurrentRpm(700);
		ecuState.setTwilightSentinelState(false);
		
		System.out.println(ecuState.getStateMessage());
		System.out.println("===============");
		System.out.println("Engine RPM: " + rpmSensor.getCurrentRpm());
		System.out.println("Optimal tire pressure level: " + tireSensor.getOptimalPressure());
		
		float currentPressure = ecuState.getCurrentTirePressure();
		System.out.println(tireSensor.checkPressure(currentPressure) + " Current pressure: " + currentPressure);
		
		boolean activated = ecuState.isTwilightSentinelActivated();
		System.out.println(twilightSentinel.informState(activated));
	}

}
