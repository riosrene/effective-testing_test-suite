package app.runner;

import app.core.BinarySensor;
import app.core.DoorSensor;
import app.core.EcuStateModule;
import app.core.FuelPumpSensor;
import app.core.IgnitionAdvanceSensor;
import app.core.RpmSensor;
import app.core.SeatBeltSensor;
import app.core.TireSensor;

public class EcuRunner {
	
	public static void main (String[] args) {
		EcuStateModule ecuState = new EcuStateModule();
		IgnitionAdvanceSensor ignitionAdvanceSensor = new IgnitionAdvanceSensor();
		RpmSensor rpmSensor = new RpmSensor();
		TireSensor tireSensor = new TireSensor();
		DoorSensor doorSensor = new DoorSensor();
		BinarySensor seatBeltSensor = new SeatBeltSensor();
		FuelPumpSensor fuelPump = new FuelPumpSensor();
		
		ecuState.setIgnition(true);
		ignitionAdvanceSensor.setAngle(40);
		ecuState.setCurrentTirePressure(25.0f);
		rpmSensor.setCurrentRpm(700);
		ecuState.setDoors(4);
		ecuState.setSeatbelts(5);
		
		System.out.println(ecuState.getStateMessage());
		
		separateLine();
		
		System.out.println("Engine RPM: " + rpmSensor.getCurrentRpm());
		
		separateLine();
		
		doorSensor.checkDoors(ecuState.getDoors()).forEach(t -> System.out.println(t));
		
		separateLine();
		
		seatBeltSensor.checkState(ecuState.getSeatbelts()).forEach(t -> System.out.println(t));
		
		separateLine();
		
		tireSensor.setMeassurementUnit("BAR");
		tireSensor.saveConfiguration("mode", "standard");
		tireSensor.setCurrentPressure(ecuState.getCurrentTirePressure());
		
		System.out.println("Tire sensor meassurement unit: " + tireSensor.getMeassurementUnit());
		System.out.println("Operation mode:" + tireSensor.showConfigValueByName("mode"));
		System.out.println("Optimal tire pressure level: " + tireSensor.getOptimalPressure());
		tireSensor.checkState(4).forEach(t -> System.out.println(t));
		
		separateLine();
		
		fuelPump.saveConfiguration("mode", "normal");
		String mode = fuelPump.showConfigValueByName("mode");
		System.out.println(fuelPump.showFuelConsumption(mode));
	}

	private static void separateLine() {
		System.out.println("\n");
	}
}
