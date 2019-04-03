package virtualecu.runner;

import virtualecu.display.EcuDashboard;
import virtualecu.input.ECT;
import virtualecu.input.TPS;

public class EcuRunner {
	
	public static void main (String[] args) {
		boolean isCelsius = true;
		ECT ect = new ECT(isCelsius);
		TPS tps = new TPS();

		tps.setAngle(40);
		EcuDashboard.showMessage(tps.GetName() + ": " + tps.getAngle() + "º");;
		
		ect.setTemperature(65.3f);
		EcuDashboard.showMessage(ect.getName() + ": " + ect.getTemperature() + "º");
	}

}
