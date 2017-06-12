package threefour;

import motej.Mote;
import motej.event.AccelerometerEvent;
import motej.event.AccelerometerListener;
import motej.event.CoreButtonEvent;
import motej.event.CoreButtonListener;
import motej.request.ReportModeRequest;

public class Wiimote {

	private final double C = 2.448979592;

	private final Mote mote;

	private final AccelerometerListener accelListener;
	private final CoreButtonListener buttonListener;

	private int[] motion = {0, 0, 0};
	private String button = "none";

	/**
	 * creates a accelerometer and button listener
	 * @param mote Mote object to associate with this one
	 */
	public Wiimote(Mote mote) {
		this.mote = mote;
		accelListener = new AccelerometerListener() {

			@Override
			public void accelerometerChanged(AccelerometerEvent evt) {
				motion[0] = evt.getX();
				motion[1] = evt.getY();
				motion[2] = evt.getZ();
			}
		};
		buttonListener = new CoreButtonListener() {

			@Override
			public void buttonPressed(CoreButtonEvent evt) {
				if (evt.isButtonAPressed() && evt.isButtonBPressed()) button = "AB";
				else if (evt.isButtonAPressed()) button = "A";
				else if (evt.isButtonBPressed()) button = "B";
				else if (evt.isButtonPlusPressed()) button = "PLUS";
				else if (evt.isNoButtonPressed()) button = "NONE";
			}
		};
		mote.addAccelerometerListener(accelListener);
		mote.setReportMode(ReportModeRequest.DATA_REPORT_0x31);
		mote.addCoreButtonListener(buttonListener);
	}

	/**
	 * Check if the remote is pointing away from the user
	 * @return true if pointing away
	 */
	public boolean pointAway() {
		double angle = 0.5; // a little above 30 degress from horizontal
		return -angle < getPitch() && getPitch() < angle;
	}

	/**
	 * Check if the remote is pointing down towards the floor
	 * @return true if pointing down
	 */
	public boolean pointDown() {
		return 1.0 < getPitch() && getPitch() < 1.57;
	}

	/**
	 * Get acceleration
	 * @return some number representing acceleration
	 */
	public double getAccel() {
		double ax = Math.abs(getMotionG()[0]);
		double ay = Math.abs(getMotionG()[1]);
		double az = Math.abs(getMotionG()[2]);
		return ax + ay + az;
	}

	/**
	 * Get pitch
	 * @return a value between -pi/2 (perfectly upward) to pi/2 (perfectly downward)
	 */
	public double getPitch() {
		// https://github.com/abstrakraft/cwiid/blob/fadf11e89b579bcc0336a0692ac15c93785f3f82/wminput/plugins/acc/acc.c#L131
		double xx = getMotionG()[0];
		double yy = getMotionG()[1];
		double zz = getMotionG()[2];
		double roll = Math.atan(xx / zz);
		if (zz <= 0.0) roll += Math.PI * ((xx > 0.0) ? 1 : -1);
		return -Math.toDegrees( Math.atan(yy / zz * Math.cos(roll)) );
	}

	/**
	 * get input from x, y, and z axes
	 * @return x axis in index 0, y axis in index 1,  etc
	 */
	public int[] getMotion() {
		return motion;
	}

	/**
	 * get motion with proper acceleration to use for calculations
	 * @return x axis in index 0, y axis in index 1,  etc
	 */
	public double[] getMotionG() {
		double[] axisG = new double[motion.length];
		for (int k = 0; k < axisG.length; k++) {
			axisG[k] = (motion[k] - 128) / C;
		}
		return axisG;
	}

	public String getButton() {
		return button;
	}

	public Mote getMote() {
		return mote;
	}

	@Override
	public String toString() {
		return mote.toString();
	}
}
