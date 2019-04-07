package virtualecu.runner;

import virtualecu.core.EcuProcessor;
import virtualecu.display.EcuDashboard;
import virtualecu.input.ECT;
import virtualecu.input.Lambda;
import virtualecu.input.MAP;
import virtualecu.input.TPS;

public class EcuRunner {
	
	public static void main (String[] args) {
		boolean isCelsius = true;
		ECT ect = new ECT(isCelsius);
		Lambda lambda = new Lambda();
		TPS tps = new TPS();
		MAP map = new MAP();
		EcuProcessor processor = new EcuProcessor();

		map.setHg(2.5f);
		EcuDashboard.showMessage(map.getName() + ": " + map.getHg() + "Hg");

		tps.setAngle(40);
		processor.dosifyFuel(tps);
		EcuDashboard.showMessage(tps.GetName() + ": " + tps.getAngle() + "º");
		EcuDashboard.showMessage(processor.getInjectorState());
		
		ect.setTemperature(65.3f);
		EcuDashboard.showMessage(ect.getName() + ": " + ect.getTemperature() + "º");
		
		float airFuelRatio = 11.5f;
		lambda.measureRatio(airFuelRatio);
		EcuDashboard.showMessage(lambda.getName() + ": is receiving " + airFuelRatio + " air/fuel ratio - " + lambda.getState());
	}

}
