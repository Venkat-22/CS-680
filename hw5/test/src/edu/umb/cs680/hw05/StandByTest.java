package edu.umb.cs680.hw05;



import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
class StandByTest {

	Escalator escalator = Escalator.getInstance();
	
	
	@Test
	@Order(2)
	void startButtonTest() {
		
        escalator.startButtonPushed();
        State actual = escalator.getState();
        State expected = StandBy.getInstance();
        Assertions.assertSame(expected, actual);
        
	}
	@Test
	@Order(3)
	void motionDetectionTest() {
		escalator.motionDetected();
		State actual = escalator.getState();
		State expected = Operating.getInstance();
        Assertions.assertSame(expected, actual);
	}
	@Test
	@Order(4)
	void motionNotDetectedTest() {
		escalator.motionNotDetected();
        State actual = escalator.getState();
        State expected = StandBy.getInstance();
        Assertions.assertSame(expected, actual);
	}
	@Test
	@Order(1)
	void stopButtonTest() {
		
        escalator.stopButtonPushed();
        State actual = escalator.getState();
        State expected = Stopped.getInstance();
        Assertions.assertSame(expected, actual);
        
	}


}
