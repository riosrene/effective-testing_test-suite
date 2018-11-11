package app.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestSeatBeltSensor {
	private BinarySensor seatBeltSensor;
	private int seatBelts;
	private List<String> messages;
	
	@Before
	public void setUp() {
		seatBeltSensor = new SeatBeltSensor();
		seatBelts = 3;
		messages = seatBeltSensor.checkState(seatBelts);
	}
	
	@Test
	public void checkStateSizeIsOk() {
		assertThat(messages.size(), is(4));
	}
	
	@Test
	public void checkStateDefaultMsgIsOk() {
		assertThat(messages.get(0), is("Attempting to check seatbelts"));
	}
	
	@Test
	public void checkStateMsgIsOk() {
		int index = 1;
		assertThat(messages.get(index), is("Checking seatbelt n° " + (index + 2)));
	}
	
	
}
