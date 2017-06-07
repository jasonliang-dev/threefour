package threefour;

import motej.Mote;
import motej.event.AccelerometerEvent;
import motej.event.AccelerometerListener;
import motej.event.CoreButtonEvent;
import motej.event.CoreButtonListener;
import motej.request.ReportModeRequest;

public class Wiimote {

	private final Mote mote;

	private final AccelerometerListener accelListener;
	private final CoreButtonListener buttonListener;

	private int[] motion = {130, 131, 152};
	private String button = "none";

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
				else if (evt.isNoButtonPressed()) button = "none";
			}
		};
		mote.addAccelerometerListener(accelListener);
		mote.setReportMode(ReportModeRequest.DATA_REPORT_0x31);
		mote.addCoreButtonListener(buttonListener);
	}

	public double getPitch() {
		// https://github.com/abstrakraft/cwiid/blob/fadf11e89b579bcc0336a0692ac15c93785f3f82/wminput/plugins/acc/acc.c#L131
		double C = 2.448979592;
		double xx = (motion[0] - 128) / C;
		double yy = (motion[1] - 128) / C;
		double zz = (motion[2] - 128) / C;
		double roll = Math.atan(xx / zz);
		if (zz <= 0.0) roll += Math.PI * ((xx > 0.0) ? 1 : -1);
		return Math.atan(yy / zz * Math.cos(roll));
	}
	
	public int[] getMotion() {
		return motion;
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
