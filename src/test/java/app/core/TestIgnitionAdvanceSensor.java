package app.core;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import org.junit.Test;	

public class TestIgnitionAdvanceSensor {
	private IgnitionAdvanceSensor advanceAdvanceSensor; 
	
	@Test
	public void ecuStateMessageAppears() {
		advanceAdvanceSensor = new IgnitionAdvanceSensor();
        assertThat(advanceAdvanceSensor, hasProperty("angle"));	
	}
}
