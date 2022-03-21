package edu.umb.cs680.hw05;

public class Stopped implements State {
	private static Stopped stopped = null;
	private static Escalator escalator;
	
	private Stopped() {}
	
	public static Stopped getInstance() {
		if (stopped == null) {
			stopped = new Stopped();
		}
		return stopped;
	}
	
	public static void setEscalator(Escalator escalator) {
		Stopped.escalator = escalator;
	}
	
	public void startButtonPushed() {
		escalator.enableSensor();
		escalator.changeState(StandBy.getInstance());
	}
	
	public void stopButtonPushed() {
		System.out.println("Does Nothing");
	}
	
	public void motionDetected() {
		System.out.println("Does Nothing");
	}
	
	public void motionNotDetected() {
		System.out.println("Does Nothing");
	}
}
