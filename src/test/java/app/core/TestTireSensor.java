package app.core;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TestTireSensor {
	TireSensor tireSensor;
	
	@Before
	public void setUp() {
		tireSensor = new TireSensor();
	}
	
	@Test
	public void containsPressureProperty() {
        assertThat(tireSensor, hasProperty("optimalPressure", is(29.3f)));
	}
	
	@Test
	public void checkPressureLow() {
		String message = tireSensor.checkPressure(25);
		assertThat(message, is("Tire pressure level is low."));
	}
	
	@Test
	public void checkPressureNormal() {
		String message = tireSensor.checkPressure(30);
		assertThat(message, is("Tire pressure level is normal."));
	}
}
