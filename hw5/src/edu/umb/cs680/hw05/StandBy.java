package edu.umb.cs680.hw05;

public class StandBy implements State{
	private static StandBy standBy = null;
	private Escalator escalator = Escalator.getInstance();

	private StandBy() {}
	
	public static StandBy getInstance() {
		if (standBy == null) {
			standBy = new StandBy();
		}
		return standBy;
	}
	
	public void startButtonPushed() {
		escalator.moveSteps();
		escalator.changeState(Operating.getInstance());
	}
	
	public void stopButtonPushed() {
		escalator.disableSensor();
		escalator.changeState(Stopped.getInstance());
	}
	
	public void motionDetected() {
		escalator.moveSteps();
		escalator.changeState(Operating.getInstance());
	}
	
	public void motionNotDetected() {
		System.out.println("Does Nothing");
	}

}
