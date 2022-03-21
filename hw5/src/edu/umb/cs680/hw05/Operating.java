package edu.umb.cs680.hw05;

public class Operating implements State{
	private static Escalator escalator;
    private static Operating operating;

    private Operating(){
        escalator = Escalator.getInstance();
    }

    public static Operating getInstance() {
        if(operating == null){
            operating = new Operating();
        }
        return operating;
    }

	public void startButtonPushed() {
			System.out.println("Does Nothing");
	}

	public void stopButtonPushed() {
		escalator.stopSteps();
		escalator.disableSensor();
		escalator.changeState(Stopped.getInstance());
	}

	public void motionDetected() {
		System.out.println("Does Nothing");
	}

	public void motionNotDetected() {
		escalator.stopSteps();
		escalator.changeState(StandBy.getInstance());
	}

}