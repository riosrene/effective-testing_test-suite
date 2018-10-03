package app.core;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TestTireSensor {
	
	@Test
	public void containsPressureProperty() {
		TireSensor tireSensor = new TireSensor();
        assertThat(tireSensor, hasProperty("pressure", is(29.3f)));
	}

}
