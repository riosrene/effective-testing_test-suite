package app.core;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestTireSensor {
	TireSensor tireSensor;
	List<String> messages;
	
	@Before
	public void setUp() {
		tireSensor = new TireSensor();
		tireSensor.setCurrentPressure(27.2f);
		messages = tireSensor.checkState(4);
	}
	
	@Test
	public void containsPressureProperty() {
        assertThat(tireSensor, hasProperty("optimalPressure", is(29.3f)));
	}
	
	@Test
	public void checkStateSizeIsOk() {
		assertThat(messages.size(), is(5));
	}
	
	@Test
	public void checkStateDefaultMsgIsOk() {
		assertThat(messages.get(0), is("Attempting to check tire pressure."));
	}
	
	@Test
	public void checkStateMsgIsOk() {
		int index = 1;
		assertThat(messages.get(index), is("Wheel " + (index+3) + "-> Tire pressure level: normal"));
	}
}
