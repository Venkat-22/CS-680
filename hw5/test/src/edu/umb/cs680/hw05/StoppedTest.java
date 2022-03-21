package edu.umb.cs680.hw05;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;


@TestMethodOrder(OrderAnnotation.class)
class StoppedTest {

	Escalator escalator = Escalator.getInstance();
	
	
	
	@Test
	@Order(1)
	void startButtonTest() {
		escalator.changeState(Stopped.getInstance());
        escalator.startButtonPushed();
        State actual = escalator.getState();
        State expected = StandBy.getInstance();
        Assertions.assertSame(expected, actual);
        
	}
	@Test
	@Order(2)
	void motionDetectionTest() {
		escalator.motionDetected();
		State actual = escalator.getState();
		State expected = Operating.getInstance();
        Assertions.assertSame(expected, actual);
	}
	@Test
	@Order(3)
	void motionNotDetectedTest() {
		escalator.motionNotDetected();
        State actual = escalator.getState();
        State expected = StandBy.getInstance();
        Assertions.assertSame(expected, actual);
	}
	@Test
	@Order(4)
	void stopButtonTest() {
		
        escalator.stopButtonPushed();
        State actual = escalator.getState();
        State expected = Stopped.getInstance();
        Assertions.assertSame(expected, actual);
        
	}


}
