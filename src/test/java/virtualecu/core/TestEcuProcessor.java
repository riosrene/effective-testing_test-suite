package virtualecu.core;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import virtualecu.input.BS;
import virtualecu.input.ECT;
import virtualecu.input.MAP;
import virtualecu.input.TPS;

public class TestEcuProcessor {
	private EcuProcessor ecuProcessor;
	private ECT ect;
	private TPS tps;
	private MAP map;
	private BS bs;
	
	@Before
	public void setUp() {
		ecuProcessor = new EcuProcessor();
		ect = new ECT(true);
		tps = new TPS();
		map = new MAP();
		bs = new BS();
	}
	
	@Test
	public void testCheckCoolantTemperature() {
		ect.setTemperature(20.3f);
		ecuProcessor.setEct(ect);
		String message = ecuProcessor.checkCoolantTemperature();
		
		assertThat(message, is(equalTo("Checking coolant temp, reaching minimum threshold in 46 secs")));
	}
	
	@Test
	public void testCheckCoolantTemperatureMax() {
		map.setHg(2.7f);
		bs.setHg(2.4f);
		tps.setAngle(40);
		ect.setTemperature(20.3f);
		ecuProcessor.setEct(ect);
		ecuProcessor.measureAirDensity(map, bs);
		ecuProcessor.dosifyFuel(tps);
		String message = ecuProcessor.checkCoolantTemperature();
		
		assertThat(message, is(equalTo("Checking coolant temp, reaching max threshold in 15 secs")));
	}

	@Test
	public void testMeasureAirDensityLow() {
		map.setHg(2.7f);
		bs.setHg(2.1f);
		
		String currentAirDensity = ecuProcessor.measureAirDensity(map, bs);
		
		assertThat(currentAirDensity, is(equalTo("low")));
	}
	
	@Test
	public void testMeasureAirDensityNormal() {
		map.setHg(5.1f);
		bs.setHg(3.1f);
		
		String currentAirDensity = ecuProcessor.measureAirDensity(map, bs);
		
		assertThat(currentAirDensity, is(equalTo("normal")));
	}
	
	@Test
	public void testMeasureAirDensityHigh() {
		map.setHg(7.7f);
		bs.setHg(3.8f);
		
		String currentAirDensity = ecuProcessor.measureAirDensity(map, bs);
		
		assertThat(currentAirDensity, is(equalTo("high")));
	}
	
	@Test
	public void testMeasureAirDensityFailed() {
		map.setHg(7.7f);
		bs.setHg(1.8f);
		
		String currentAirDensity = ecuProcessor.measureAirDensity(map, bs);
		
		assertThat(currentAirDensity, is(equalTo("failed")));
	}
}
