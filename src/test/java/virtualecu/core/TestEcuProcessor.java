package virtualecu.core;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import virtualecu.input.BS;
import virtualecu.input.MAP;

public class TestEcuProcessor {
	private EcuProcessor ecuProcessor;
	private MAP map;
	private BS bs;
	
	@Before
	public void setUp() {
		ecuProcessor = new EcuProcessor();
		map = new MAP();
		bs = new BS();
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
