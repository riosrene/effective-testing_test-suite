package virtualecu.output;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import virtualecu.core.instruction.FuelDosis;

public class TestFuelInjector {
	private FuelInjector fuelInjector;
	
	@Before
	public void setUp() {
		fuelInjector = new FuelInjector(true);
	}
	
	@Test
	public void testInjectEfficiencyMode() {
		fuelInjector.interruptVoltage(); 
		fuelInjector.inject(FuelDosis.STAGE_O);
		
		assertThat(fuelInjector.getState(), is(equalTo("injecting fuel, efficiency mode")));
	}
	
	@Test
	public void testInjectNormalMode() {
		fuelInjector.interruptVoltage(); 
		fuelInjector.inject(FuelDosis.STAGE_1);
		
		assertThat(fuelInjector.getState(), is(equalTo("injecting fuel, normal mode")));
	}

	@Test
	public void testInjectNormalMode2() {
		fuelInjector.interruptVoltage(); 
		fuelInjector.inject(FuelDosis.STAGE_2);
		
		assertThat(fuelInjector.getState(), is(equalTo("injecting fuel, normal mode")));
	}
	
	@Test
	public void testInjectFullMode() {
		fuelInjector.interruptVoltage(); 
		fuelInjector.inject(FuelDosis.STAGE_3);
		
		assertThat(fuelInjector.getState(), is(equalTo("injecting fuel, full capacity")));
	}

}
