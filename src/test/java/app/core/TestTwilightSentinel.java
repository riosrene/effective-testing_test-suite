package app.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TestTwilightSentinel {
	TwilightSentinel twilightSentinel;
	
	@Before
	public void setUp() {
		twilightSentinel = new TwilightSentinel();
	}

	@Test
	public void informStateActivated() {
		String message = twilightSentinel.informState(true);
		assertThat(message, is("Twilight Sensor activated."));
	}
	
	@Test
	public void informStateDeactivated() {
		String message = twilightSentinel.informState(false);
		assertThat(message, is("Twilight Sensor deactivated."));
	}
}
