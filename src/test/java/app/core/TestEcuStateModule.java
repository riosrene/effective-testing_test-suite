package app.core;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TestEcuStateModule {
	private EcuStateModule ecuModule; 
	
	@Before
	public void setUp() {
		ecuModule = new EcuStateModule();
	}
	
	@Test
	public void ecuStateMessageAppears() {
        assertThat(ecuModule, hasProperty("stateMessage", is("ECU started.")));	
	}

	@Test
	public void containsIgnitionProperty() {
        assertThat(ecuModule, hasProperty("ignition"));	
	}
}
